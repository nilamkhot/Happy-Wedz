package com.dataversity.happywedz;

import android.os.Bundle;

import com.dataversity.happywedz.utils.Tools;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Tools.setSystemBarColor(this, R.color.grey_10);
        Tools.setSystemBarLight(this);



    }
}