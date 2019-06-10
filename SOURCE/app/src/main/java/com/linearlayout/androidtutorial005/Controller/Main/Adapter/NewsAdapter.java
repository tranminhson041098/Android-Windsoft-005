package com.linearlayout.androidtutorial005.Controller.Main.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.linearlayout.androidtutorial005.R;

public class NewsAdapter {
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
