package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dataversity.happywedz.utils.Tools;

public class MyChecklistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_checklist);

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

    }
}