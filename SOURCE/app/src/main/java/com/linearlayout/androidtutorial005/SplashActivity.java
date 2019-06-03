package com.linearlayout.androidtutorial005;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //hàm handler gọi xem bao nhiêu s thì gọi hàm khác

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                screenRouter();
            }
        }, 2000);
    }


    void screenRouter() {
        String phoneNumber = AppConfig.getPhoneNumber(this);
        /*
        SharedPreferences sharedPreferences = getSharedPreferences("Android005",MODE_PRIVATE);
       // sharedPreferences.getString("phone_number",null);
        //Lấy dữ liệu key
        String phoneNumber = sharedPreferences.getString("phone_number",null);*/
        if (phoneNumber == null) {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);

        } else {

            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);


            User user;
            user = new User();
            user.setId(1);
            user.setUsername("Trần Sơn");
            user.setPhoneNumber("0912230109");
            intent.putExtra("user", user);



            //lưu số điện thoại lần sau vào thẳng main user
            startActivity(intent);
            finish();

        }
    }
}
