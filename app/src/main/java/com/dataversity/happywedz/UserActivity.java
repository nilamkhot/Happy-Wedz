package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dataversity.happywedz.utils.Tools;

public class UserActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        findViewById(R.id.inbox_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InboxActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.write_review).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WriteReviewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.genei_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GenieServiceActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.genie_recommendation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GenieRecommendationActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.join_a_wedding).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JoinWedding.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.promotion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PromotionActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AboutHappyWedz.class);
                startActivity(intent);
            }
        });

    }
}