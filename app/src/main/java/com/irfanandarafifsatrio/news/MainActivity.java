package com.irfanandarafifsatrio.news;

import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.irfanandarafifsatrio.news.adapter.ArticleAdapter;
import com.irfanandarafifsatrio.news.adapter.RecyclerItemClickListener;
import com.irfanandarafifsatrio.news.dao.ArticleDao;
import com.irfanandarafifsatrio.news.dao.SourceDao;
import com.irfanandarafifsatrio.news.preference.SourcePref;
import com.irfanandarafifsatrio.news.service.ArticleClient;
import com.irfanandarafifsatrio.news.service.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<ArticleDao.ArticlesBean> articles = new ArrayList<>();
    private ArticleAdapter articleAdapter;
    private RecyclerView rvArticle;
    private LinearLayoutManager lmArticle;
    private LinearLayout chooseSource;
    private TextView src;
    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        src = (TextView) findViewById(R.id.src);
        animationView = (LottieAnimationView) findViewById(R.id.animationView);

        rvArticle = (RecyclerView) findViewById(R.id.rvArticle);
        lmArticle = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvArticle.setLayoutManager(lmArticle);
        articleAdapter = new ArticleAdapter(this,articles);
        rvArticle.setAdapter(articleAdapter);

        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(rvArticle);

        chooseSource = (LinearLayout) findViewById(R.id.chooseSource);
        chooseSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this,SourceActivity.class), Constant.REQUEST_CODE_CHOOSE_SOURCE);
            }
        });

        rvArticle.addOnItemTouchListener(new RecyclerItemClickListener(this,rvArticle,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                        builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));
                        CustomTabsIntent customTabsIntent = builder.build();
                        customTabsIntent.launchUrl(MainActivity.this, Uri.parse(articles.get(position).getUrl()));
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );

        SourceDao.SourcesBean sourcesBean = SourcePref.load(this);
        if (sourcesBean==null) {
            src.setText("Hacker News");
            loadArticle("hacker-news");
        }else{
            src.setText(sourcesBean.getName());
            loadArticle(sourcesBean.getId());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_CODE_CHOOSE_SOURCE){
            if(resultCode == RESULT_OK){
                articles.clear();
                articleAdapter.notifyDataSetChanged();
                SourceDao.SourcesBean sourcesBean = SourcePref.load(this);
                src.setText(sourcesBean.getName());
                loadArticle(sourcesBean.getId());
            }
        }
    }

    private void loadArticle(String source) {
        rvArticle.setVisibility(View.GONE);
        animationView.setVisibility(View.VISIBLE);

        ArticleClient client = Service.createService(ArticleClient.class);
        Call<ArticleDao> call = client.getArticle(source);
        call.enqueue(new Callback<ArticleDao>() {
            @Override
            public void onResponse(Call<ArticleDao> call, Response<ArticleDao> response) {
                if (response.isSuccessful()) {
                    ArticleDao dao = response.body();
                    articles.addAll(dao.getArticles());
                    articleAdapter.notifyItemInserted(articles.size());

                    rvArticle.setVisibility(View.VISIBLE);
                    animationView.setVisibility(View.GONE);
                }else{
                    Log.i("infotes", "onResponse loadArticle: "+response.raw());
                    onFailure(call,null);
                }
            }

            @Override
            public void onFailure(Call<ArticleDao> call, Throwable t) {
                if (t!=null)
                    Log.i("infotes", "onFailure loadArticle: "+t.getMessage());
                Toast.makeText(MainActivity.this, "Gagal Mengambil Data", Toast.LENGTH_SHORT).show();

                animationView.setVisibility(View.GONE);
            }
        });
    }
}
