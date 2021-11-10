package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dataversity.happywedz.adapter.PhotographerAdapter;
import com.dataversity.happywedz.adapter.VenuesActivityAdapter;
import com.dataversity.happywedz.utils.Tools;

public class VenuesActivity extends AppCompatActivity {
    Context context;
    RecyclerView venues_child_recyclerview;
    LinearLayoutManager category_layoutManager;
    VenuesActivityAdapter venuesActivityAdapter;
    TextView filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venues);
        context = this;

        Tools.setSystemBarColor(this, R.color.grey_10);
        Tools.setSystemBarLight(this);

        ShowVenuesList();

        filter= findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FilterActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.genie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GenieActivity.class);
                startActivity(intent);
            }
        });

    }

    private void ShowVenuesList() {

        venues_child_recyclerview = findViewById(R.id.venues_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        venuesActivityAdapter = new VenuesActivityAdapter(context);
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        venues_child_recyclerview.setAdapter(venuesActivityAdapter);
        venues_child_recyclerview.setLayoutManager(category_layoutManager);

    }

}