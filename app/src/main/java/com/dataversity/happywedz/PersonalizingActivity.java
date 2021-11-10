package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.dataversity.happywedz.utils.Tools;

public class PersonalizingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalizing);

        Tools.setSystemBarColor(this, R.color.grey_10);
        Tools.setSystemBarLight(this);

        Thread loading = new Thread() {
            public void run() {
                try {
                    sleep(2000);

                    Intent main = new Intent(PersonalizingActivity.this, DashboardActivity.class);
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