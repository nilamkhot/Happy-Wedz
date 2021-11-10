package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dataversity.happywedz.utils.Tools;

public class OtpVerificationActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        context = this;

        Tools.setSystemBarColor(this, R.color.grey_10);
        Tools.setSystemBarLight(this);

        findViewById(R.id.verify_otp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TellUsActivity.class);
                startActivity(intent);
            }
        });
    }
}