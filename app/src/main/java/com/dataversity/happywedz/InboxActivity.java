package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.dataversity.happywedz.adapter.InboxAdapter;
import com.dataversity.happywedz.adapter.SearchCityAdapter;
import com.dataversity.happywedz.utils.Tools;

public class InboxActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerview;
    LinearLayoutManager category_layoutManager;
    InboxAdapter inboxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        recyclerview = findViewById(R.id.recyclerview);
        category_layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        inboxAdapter = new InboxAdapter(context);
        // and adapter for items
        // of the parent recyclerview
        recyclerview.setAdapter(inboxAdapter);
        recyclerview.setLayoutManager(category_layoutManager);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }
}