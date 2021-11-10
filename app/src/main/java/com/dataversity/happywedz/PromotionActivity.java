package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dataversity.happywedz.utils.Tools;

public class PromotionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);
    }
}