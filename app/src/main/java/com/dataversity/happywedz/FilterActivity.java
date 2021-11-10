package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dataversity.happywedz.adapter.CategoryAdapter;
import com.dataversity.happywedz.adapter.Filter_bottom_Adapter;
import com.dataversity.happywedz.utils.Tools;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class FilterActivity extends AppCompatActivity {
    Context context;
    CardView no_of_guest;
    private BottomSheetBehavior mBehavior;
    private BottomSheetDialog mBottomSheetDialog;
    private View bottom_sheet;
    LinearLayoutManager category_layoutManager;
    Filter_bottom_Adapter filter_bottom_adapter;
    private String no_of_guest_list[] = {
            "< 100", "100-250", "250-500", "500-1000", "> 1000"
    };

    private String price_per_plate_list[] = {
            "< 1000", "1000-1500", "1500-2000", "2000-3000", "> 3000", "Rental", "Price on request"
    };

    private String venue_type_list[] = {
            "4 Star & Above Hotels", "Lawns/Farmhouses", "Hotels", "Country/ Golf Club", "Resorts", "Restaurant/Party Lounge Bar",
            "Heritage Property", "Destination Wedding", "Kalyan Mandapam", "Small Function Halls", "Venues With Rooms"
    };

    private String space_prefernce_list[] = {
            "Indoor", "Outdoor", "Indoor with outdoor", "Poolside", "Terrace" };

    private String rating_list[] = {
            "All Ratings", "Rated <4", "Rated 4+", "Rated 4.5+"};

    private String rvaccinated_list[] = {
            "Vaccinated"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        bottom_sheet = findViewById(R.id.bottom_sheet);
        mBehavior = BottomSheetBehavior.from(bottom_sheet);

        findViewById(R.id.selected_city).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SearchCity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.select_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SearchLocalityActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.no_of_guest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 showBottomSheetDialog("No.of guests");
            }
        });

        findViewById(R.id.price_per_plate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog("Price per plate");
            }
        });

        findViewById(R.id.venue_type).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog("Venue Type");
            }
        });

        findViewById(R.id.space_prefernce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog("Space Preference");
            }
        });

        findViewById(R.id.rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog("Rating");
            }
        });

        findViewById(R.id.vaccinated).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog("Vaccinated");
            }
        });

    }

    private void showBottomSheetDialog(String title_text) {
        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        final View view = getLayoutInflater().inflate(R.layout.bottomsheet_layout, null);
        TextView title = ((TextView) view.findViewById(R.id.title));
        TextView ok = ((TextView) view.findViewById(R.id.ok));
        RecyclerView recyclerview = view.findViewById(R.id.recyclerview);
        LinearLayout search_layout = view.findViewById(R.id.search_layout);

        category_layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        if(title_text.matches("No.of guests")){
            title.setText("Select "+ title_text);
            filter_bottom_adapter = new Filter_bottom_Adapter(context, no_of_guest_list);

        }else  if(title_text.matches("Price per plate")){
            title.setText("Select "+ title_text);
            filter_bottom_adapter = new Filter_bottom_Adapter(context, price_per_plate_list);

        }else  if(title_text.matches("Venue Type")){
            search_layout.setVisibility(View.VISIBLE);
            title.setText("Select "+ title_text);
            filter_bottom_adapter = new Filter_bottom_Adapter(context, venue_type_list);

        }else  if(title_text.matches("Space Preference")){
            title.setText("Select "+ title_text);
            filter_bottom_adapter = new Filter_bottom_Adapter(context, space_prefernce_list);

        }else  if(title_text.matches("Rating")){
            ok.setVisibility(View.GONE);
            title.setText("Select "+ title_text);
            filter_bottom_adapter = new Filter_bottom_Adapter(context, rating_list);

        }else  if(title_text.matches("Vaccinated")){
            ok.setVisibility(View.GONE);
            title.setText("Select "+ title_text);
            filter_bottom_adapter = new Filter_bottom_Adapter(context, rvaccinated_list);

        }

        recyclerview.setAdapter(filter_bottom_adapter);
        recyclerview.setLayoutManager(category_layoutManager);



        mBottomSheetDialog = new BottomSheetDialog(this);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.setContentView(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBottomSheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        mBottomSheetDialog.show();
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mBottomSheetDialog = null;
            }
        });
    }

}