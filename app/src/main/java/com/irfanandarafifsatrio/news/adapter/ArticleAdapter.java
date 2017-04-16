package com.irfanandarafifsatrio.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.irfanandarafifsatrio.news.R;
import com.irfanandarafifsatrio.news.dao.ArticleDao;
import com.irfanandarafifsatrio.news.helper.Helper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irfanandarafifsatrio on 4/15/17.
 */

public class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ArticleDao.ArticlesBean> list = new ArrayList<>();

    public ArticleAdapter(Context context, List<ArticleDao.ArticlesBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.article_item, parent, false);
            return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemHolder) holder).title.setText(list.get(position).getTitle());
        ((ItemHolder) holder).desc.setText(list.get(position).getDescription());
        if (list.get(position).getPublishedAt()!=null)
            ((ItemHolder) holder).date.setText(Helper.dateFormater(list.get(position).getPublishedAt()));
        Picasso.with(context)
                .load(list.get(position).getUrlToImage())
                .into(((ItemHolder) holder).img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView desc;
        TextView date;
        ImageView img;

        ItemHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            desc = (TextView) itemView.findViewById(R.id.desc);
            date = (TextView) itemView.findViewById(R.id.date);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}