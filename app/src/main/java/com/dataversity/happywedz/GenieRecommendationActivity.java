package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.dataversity.happywedz.utils.Tools;

public class GenieRecommendationActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genie_recommendation);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);
    }
}