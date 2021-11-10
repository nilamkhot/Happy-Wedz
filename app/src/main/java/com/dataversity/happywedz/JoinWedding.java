package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dataversity.happywedz.utils.Tools;

public class JoinWedding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_wedding);

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);
    }
}