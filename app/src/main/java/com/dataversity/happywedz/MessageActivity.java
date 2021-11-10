package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dataversity.happywedz.utils.Tools;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);
    }
}