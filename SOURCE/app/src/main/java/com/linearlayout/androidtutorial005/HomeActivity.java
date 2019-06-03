package com.linearlayout.androidtutorial005;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.linearlayout.androidtutorial005.Model.HomeData;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class HomeActivity extends AppCompatActivity
{
    HomeData homeData;
    TextView tvUsername, tvPhoneNumber ,tvNews1,tvNews2,tvNews3,tvNews4,tvNews5;
    ImageView imgInfo1, imgInfo2, imgInfo3, imgInfo4 , imgInfo5;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        init();
        docJson();
    }


    private void docJson() {
        String strhomeData = loadJSONFromAsset();
        Gson gson = new Gson();

        //Con vert từ String strhomeData sang đối tượng Homedata
        HomeData homeData =gson.fromJson(strhomeData,HomeData.class);

        //Thử Toast tên xem ddungs chưa
        String customerName = homeData.getResult().getCustomerDetail().getCustomerName();

        tvUsername.setText(customerName);

        String news1 = homeData.getResult().getListNews().get(0).getTitle();
        String news2 = homeData.getResult().getListNews().get(1).getTitle();
        String news3 = homeData.getResult().getListNews().get(2).getTitle();
        String news4 = homeData.getResult().getListPromotion().get(0).getTitle();
        String news5 =homeData.getResult().getListPromotion().get(1).getTitle();
        //-------------------------------------------------------------------
        tvNews1.setText(news1);
        tvNews2.setText(news2);
        tvNews3.setText(news3);
        tvNews4.setText(news4);
        tvNews5.setText(news5);





    }


    public String loadJSONFromAsset()
    {
       String str =null;
       try {

           InputStream is = getAssets().open("home.json");
           int size = is.available();
           byte[] buffer = new byte[size];
           is.read(buffer);
           is.close();
           str = new String(buffer, "UTF-8");
       }
       catch(IOException ex)
       {
           ex.printStackTrace();
           return null;
       }
     return str;
    }
    void init()
    {
        tvUsername = findViewById(R.id.tv_user_name);
        tvPhoneNumber=findViewById(R.id.tv_phone_number);
        tvNews1=findViewById(R.id.tv_news_one);
        tvNews2=findViewById(R.id.tv_news_two);
        tvNews3=findViewById(R.id.tv_news_three);
        tvNews4=findViewById(R.id.tv_news_four);
        tvNews5=findViewById(R.id.tv_news_five);
        imgInfo1=findViewById(R.id.img_one);
        imgInfo2=findViewById(R.id.img_two);
        imgInfo3=findViewById(R.id.img_three);
        imgInfo4=findViewById(R.id.img_four);
        imgInfo5=findViewById(R.id.img_five);


    }
}
