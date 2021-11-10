package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.dataversity.happywedz.adapter.CircularAdapter;
import com.dataversity.happywedz.adapter.ShopBrowseAdapter;
import com.dataversity.happywedz.adapter.TrendingAdapter;
import com.dataversity.happywedz.adapter.TrendingNowAdapter;
import com.dataversity.happywedz.utils.Tools;

public class ShopDetailActivity extends AppCompatActivity {
    Context context;
    RecyclerView brand_recyclerview, viewed_recyclerview,type_recyclerview;
    LinearLayoutManager linearLayoutManager;
    TrendingNowAdapter trendingNowAdapter;
    TrendingAdapter trendingAdapter;
    CircularAdapter circularAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        showBrandRecycler();
        showViewedRecycler();
        ShowCircular();

    }

    private void ShowCircular() {

        type_recyclerview = findViewById(R.id.type_recyclerview);

        linearLayoutManager = new GridLayoutManager(context, 2);
        circularAdapter = new CircularAdapter(context);
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        type_recyclerview.setAdapter(circularAdapter);
        type_recyclerview.setLayoutManager(linearLayoutManager);


    }

    private void showBrandRecycler() {
        brand_recyclerview = findViewById(R.id.brand_recyclerview);

        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false);
        trendingNowAdapter = new TrendingNowAdapter(context);
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        brand_recyclerview.setAdapter(trendingNowAdapter);
        brand_recyclerview.setLayoutManager(linearLayoutManager);
    }

    private void showViewedRecycler() {
        viewed_recyclerview = findViewById(R.id.viewed_recyclerview);

        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false);
        trendingAdapter = new TrendingAdapter(context);
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        viewed_recyclerview.setAdapter(trendingAdapter);
        viewed_recyclerview.setLayoutManager(linearLayoutManager);
    }

}