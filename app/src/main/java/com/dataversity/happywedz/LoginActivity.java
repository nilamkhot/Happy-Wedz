package com.dataversity.happywedz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dataversity.happywedz.utils.Tools;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        findViewById(R.id.send_otp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OtpVerificationActivity.class);
                startActivity(intent);
            }
        });


    }
}