package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dataversity.happywedz.adapter.RealWeddingAdapter;
import com.dataversity.happywedz.adapter.VenueVideoAdapter;
import com.dataversity.happywedz.adapter.VenuesActivityAdapter;
import com.dataversity.happywedz.utils.Tools;

public class VenueDetailActivity extends AppCompatActivity {
    Context context;
    RecyclerView video_recycleview, browse_recyclerview;
    VenueVideoAdapter venueVideoAdapter;
    GridLayoutManager gridLayoutManager;
    LinearLayoutManager category_layoutManager;
    VenuesActivityAdapter venuesActivityAdapter;
    TextView send_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_detail);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        video_recycleview = findViewById(R.id.video_recycleview);
        send_message = findViewById(R.id.send_message);

        gridLayoutManager = new GridLayoutManager(context, 2);
        venueVideoAdapter = new VenueVideoAdapter(context);
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        video_recycleview.setAdapter(venueVideoAdapter);
        video_recycleview.setLayoutManager(gridLayoutManager);

        browse_recyclerview = findViewById(R.id.browse_recyclerview);

        category_layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        venuesActivityAdapter = new VenuesActivityAdapter(context);
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        browse_recyclerview.setAdapter(venuesActivityAdapter);
        browse_recyclerview.setLayoutManager(category_layoutManager);

        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OTPActivity.class);
                startActivity(intent);
            }
        });
    }
}