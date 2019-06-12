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

import com.linearlayout.androidtutorial005.Model.Promotion;
import com.linearlayout.androidtutorial005.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder> {
    List<Promotion> data;
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<Promotion> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.promotion_item_layout, viewGroup, false);
        return new PromotionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder promotionViewHolder, int i) {
        Promotion promotion = data.get(i);
        promotionViewHolder.tvPromotionTitle.setText(promotion.getTitle());
        Picasso.get().load(promotion.getUrlImage()).into(promotionViewHolder.imgPromotion);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PromotionViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPromotion;
        TextView tvPromotionTitle;
        Button btnPromotion;

        public PromotionViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPromotion = itemView.findViewById(R.id.img_bg2);
            tvPromotionTitle = itemView.findViewById(R.id.tv_title2);
            btnPromotion = itemView.findViewById(R.id.btn_detail2);
        }
    }
}
