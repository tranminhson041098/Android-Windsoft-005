package com.linearlayout.androidtutorial005;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        //Khai báo các thành phần cần quan tâm
        init();



    }
    void init()
    {
        edtPhoneNumber = (EditText) findViewById(R.id.edt_phone_number);
        RelativeLayout rlLogin = findViewById(R.id.rl_login_button);
        ImageView imgFB = findViewById(R.id.img_fb_login);
        ImageView imgGG=findViewById(R.id.img_gg_login);

// Suy nghĩ xem đang làm việc với đối tượng nào

        rlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, edtPhoneNumber.getText().toString(), Toast.LENGTH_LONG).show();
                checkValid();
                if (checkValid())
                {

                    Intent intent =new Intent(LoginActivity.this, HomeActivity.class);

                    User user;
                    user = new User();
                    user.setId(1);
                    user.setUsername("Trần Sơn");
                    user.setPhoneNumber("0912230109");
                    intent.putExtra("user",user);

                    //maybe gọi trực tiếp hàm
                    AppConfig.setPhoneNumber(edtPhoneNumber.getText().toString(),LoginActivity.this);

                    //lưu số điện thoại lần sau vào thẳng main user
                    startActivity(intent);
                    finish();

                }
                else
                {

                    Toast.makeText(LoginActivity.this, "Vui lòng thử lại", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    /*
    //Học về Shared Preferences
    void setPhoneNumber()
    {
        //tạo 1 đối truong share pre , nếu chjuwa có thì tạo mới , nếu có r thì lấy ra trực tiếp luôn
        SharedPreferences sharedPreferences = getSharedPreferences("Android005",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //tương tự truyền dữ liệu vô intent
        editor.putString("phone_number",edtPhoneNumber.getText().toString());
        //Cập nhật
        editor.apply();


    }
    */

    boolean checkValid()
    {
        //Một hàm dừng khi gặp return
        int phoneLentgth= edtPhoneNumber.getText().toString().length();
        if (phoneLentgth > 9)
        {
            return true;
        }

        return false;

    }
}
