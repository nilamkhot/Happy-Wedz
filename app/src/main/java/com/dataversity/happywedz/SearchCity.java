package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.dataversity.happywedz.adapter.RealWeddingAdapter;
import com.dataversity.happywedz.adapter.SearchCityAdapter;
import com.dataversity.happywedz.adapter.VendorAdapter;
import com.dataversity.happywedz.utils.Tools;

public class SearchCity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerview;
    LinearLayoutManager category_layoutManager;
    SearchCityAdapter searchCityAdapter;

    private String search_city_list[] = {
            "Delhi NCR", "Mumbai", "Banglore", "Hyderabad", "Chennai", "Pune", "Kolkata" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_city);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        recyclerview = findViewById(R.id.recyclerview);

        category_layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        searchCityAdapter = new SearchCityAdapter(context, search_city_list, new SearchCityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        // and adapter for items
        // of the parent recyclerview
        recyclerview.setAdapter(searchCityAdapter);
        recyclerview.setLayoutManager(category_layoutManager);


    }
}