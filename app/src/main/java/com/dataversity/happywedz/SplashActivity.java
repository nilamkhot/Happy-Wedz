package com.dataversity.happywedz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.dataversity.happywedz.utils.Tools;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

            Thread loading = new Thread() {
                public void run() {
                    try {
                        sleep(3000);

                        Intent main = new Intent(SplashActivity.this, OnBoardingActivity.class);
                        startActivity(main);
                        finish();

                    }

                    catch (Exception e) {
                        e.printStackTrace();
                    }

                    finally {
                        finish();
                    }
                }
            };

            loading.start();
    }

}