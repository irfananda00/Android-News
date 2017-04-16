package com.irfanandarafifsatrio.news;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.irfanandarafifsatrio.news.adapter.RecyclerItemClickListener;
import com.irfanandarafifsatrio.news.adapter.SourceAdapter;
import com.irfanandarafifsatrio.news.dao.SourceDao;
import com.irfanandarafifsatrio.news.preference.SourcePref;
import com.irfanandarafifsatrio.news.service.Service;
import com.irfanandarafifsatrio.news.service.SourceClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SourceActivity extends AppCompatActivity {

    private List<SourceDao.SourcesBean> sources = new ArrayList<>();
    private SourceAdapter sourceAdapter;
    private RecyclerView rvSource;
    private LinearLayoutManager lmSource;
    private Toolbar toolbar;
    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Choose Source");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        animationView = (LottieAnimationView) findViewById(R.id.animationView);

        rvSource = (RecyclerView) findViewById(R.id.rvSource);
        lmSource = new LinearLayoutManager(this);
        rvSource.setLayoutManager(lmSource);
        sourceAdapter = new SourceAdapter(this,sources);
        rvSource.setAdapter(sourceAdapter);

        rvSource.addOnItemTouchListener(new RecyclerItemClickListener(this,rvSource,
                new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    SourcePref.clearAll(SourceActivity.this);
                    SourcePref.save(sources.get(position),SourceActivity.this);
                    Intent resultIntent = new Intent();
                    SourceActivity.this.setResult(Activity.RESULT_OK, resultIntent);
                    SourceActivity.this.finish();
                }

                @Override
                public void onLongItemClick(View view, int position) {

                }
            })
        );

        loadSource();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    private void loadSource() {
        rvSource.setVisibility(View.GONE);
        animationView.setVisibility(View.VISIBLE);

        SourceClient client = Service.createService(SourceClient.class);
        Call<SourceDao> call = client.getSource();
        call.enqueue(new Callback<SourceDao>() {
            @Override
            public void onResponse(Call<SourceDao> call, Response<SourceDao> response) {
                if (response.isSuccessful()) {
                    SourceDao dao = response.body();
                    sources.addAll(dao.getSources());
                    sourceAdapter.notifyItemInserted(sources.size());

                    rvSource.setVisibility(View.VISIBLE);
                    animationView.setVisibility(View.GONE);
                }else{
                    Log.i("infotes", "onResponse loadSource: "+response.raw());
                    onFailure(call,null);
                }
            }

            @Override
            public void onFailure(Call<SourceDao> call, Throwable t) {
                if (t!=null)
                    Log.i("infotes", "onFailure loadSource: "+t.getMessage());
                Toast.makeText(SourceActivity.this, "Gagal Mengambil Data", Toast.LENGTH_SHORT).show();

                animationView.setVisibility(View.GONE);
            }
        });
    }
}
