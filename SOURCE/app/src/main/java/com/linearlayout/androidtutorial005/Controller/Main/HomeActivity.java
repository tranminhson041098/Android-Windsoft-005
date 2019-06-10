package com.linearlayout.androidtutorial005.Controller.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.linearlayout.androidtutorial005.Model.HomeData;
import com.linearlayout.androidtutorial005.R;
import com.linearlayout.androidtutorial005.Utils.Utils;

import java.io.IOException;
import java.io.InputStream;

public class HomeActivity extends AppCompatActivity {
    HomeData homeData;
    TextView tvUsername, tvPhoneNumber, tvNews1, tvNews2, tvNews3, tvNews4, tvNews5;
    ImageView imgInfo1, imgInfo2, imgInfo3, imgInfo4, imgInfo5;
    RecyclerView rvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        init();
        docJson();
        configRvNews();

    }


    private void docJson() {
        String strhomeData = Utils.loadJSONFromAsset(this);
        Gson gson = new Gson();

        //Con vert từ String strhomeData sang đối tượng Homedata
        homeData = gson.fromJson(strhomeData, HomeData.class);


    }


    //
    void init() {
        rvNews = findViewById(R.id.rv_news);

    }

    void configRvNews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvNews.setLayoutManager(linearLayoutManager);
        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {


            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(HomeActivity.this).inflate(R.layout.news_item_layout, viewGroup, false);
                RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view) {
                    @Override
                    public String toString() {

                        return super.toString();

                    }
                };


              //  return viewHolder;
           return null;

            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }

            @Override
            public int getItemCount() {
                return homeData.getResult().getListNews().size();
            }
        };
        rvNews.setAdapter(adapter);
    }
}
