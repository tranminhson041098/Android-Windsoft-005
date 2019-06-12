package com.linearlayout.androidtutorial005.Controller.Main.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.linearlayout.androidtutorial005.Model.News;
import com.linearlayout.androidtutorial005.Model.Promotion;
import com.linearlayout.androidtutorial005.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    public List<News> data;
    Context context;
    public List<Promotion> data1;

    public void setContext(Context context) {
        this.context = context;
    }

    public List<News> getData() {
        return data;
    }

    public void setData(List<News> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item_layout,viewGroup,false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view);

        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {

        News news = data.get(i);
        newsViewHolder.tvTitle.setText(news.getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  NewsViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgBg;
        TextView tvTitle;
        Button btnDetail;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBg=itemView.findViewById(R.id.img_bg);
            tvTitle=itemView.findViewById(R.id.tv_title);
            btnDetail=itemView.findViewById(R.id.btn_detail);
        }
    }


}
