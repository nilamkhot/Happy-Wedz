package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dataversity.happywedz.adapter.SearchCityAdapter;
import com.dataversity.happywedz.adapter.Search_locality_Adapter;
import com.dataversity.happywedz.utils.Tools;

public class SearchLocalityActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerview;
    LinearLayoutManager category_layoutManager;
    Search_locality_Adapter searchLocalityAdapter;
    CheckBox checkall;
    TextView apply;

    private String search_locality_list[] = {
            "Agarkar Nagar", "Alandi", "Ambegaon", "Aundh", "Balewadi", "Baner", "Bavdhan" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_locality);

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        recyclerview = findViewById(R.id.recyclerview);
        checkall = findViewById(R.id.checkall);
        apply = findViewById(R.id.apply);

        category_layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        searchLocalityAdapter = new Search_locality_Adapter(context, search_locality_list);
        // and adapter for items
        // of the parent recyclerview
        recyclerview.setAdapter(searchLocalityAdapter);
        recyclerview.setLayoutManager(category_layoutManager);

        checkall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkall.isChecked()){
                    searchLocalityAdapter.selectAll();
                }
                else {
                    searchLocalityAdapter.unselectall();
                }


            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}