package com.linearlayout.androidtutorial005.Utils;

import android.content.Context;
import android.content.SharedPreferences;
//Lưu j ở SharePreferences thì viết vô hàm này
public class AppConfig {
    public static void setPhoneNumber(String phoneNumber, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Android005", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

    //phải tự nhớ tên biến
        editor.putString("phone_number", phoneNumber);
        editor.apply();

    }
    public static  String getPhoneNumber(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Android005", Context.MODE_PRIVATE);
        return  sharedPreferences.getString("phone_number",null);
    }

}
