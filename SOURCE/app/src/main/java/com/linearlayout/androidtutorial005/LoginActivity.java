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
                    Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);

                }
                else
                {

                    Toast.makeText(LoginActivity.this, "Vui lòng thử lại", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

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
