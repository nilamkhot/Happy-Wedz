package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dataversity.happywedz.utils.Tools;

public class AboutHappyWedz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_happy_wedz);

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

    }
}