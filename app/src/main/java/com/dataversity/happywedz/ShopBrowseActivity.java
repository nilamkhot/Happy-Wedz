package com.dataversity.happywedz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dataversity.happywedz.adapter.FilterTypeAdapter;
import com.dataversity.happywedz.adapter.Filter_SubType_Adapter;
import com.dataversity.happywedz.adapter.Filter_bottom_Adapter;
import com.dataversity.happywedz.adapter.SearchCityAdapter;
import com.dataversity.happywedz.adapter.ShopBrowseAdapter;
import com.dataversity.happywedz.adapter.TrendingNowAdapter;
import com.dataversity.happywedz.utils.Tools;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ShopBrowseActivity extends AppCompatActivity{
    Context context;
    RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4;
    LinearLayoutManager linearLayoutManager, subLinearlayoutmanager;
    ShopBrowseAdapter trendingNowAdapter;
    private BottomSheetBehavior mBehavior;
    private BottomSheetDialog mBottomSheetDialog;
    private View bottom_sheet;
    FilterTypeAdapter filterTypeAdapter;
    Filter_SubType_Adapter filter_subType_adapter;
    LinearLayout filter;
    RecyclerView sub_recyclerview;
    LinearLayout msg_linear;
    ImageView close_msg;

    private String type_list[] = {
            "Outfit Type", "Occasion", "Price", "City", "Brand", "Colours", "Fabric", "Style"};

    private String outfit_list[] = {
            "Lehenga", "Sarees", "Bridal Lehenga", "Gowns", "Indo Western", "Sharara", "Drape sarees", "Jackets"};

    private String occasion_list[] = {
            "Bridesmaids", "Mehendi", "Sangeet", "Engagement", "Reception", "Wedding", "Cocktail", "Haldi"};

    private String Price_list[] = {
            "20,000 to 50,000", "50,000 to 80,000", "80,000 to 1,20,000"};

    private String city_list[] = {
            "Delhi NCR", "Mumbai", "Hyderabaad", "Bangalore"};

    private String brand_list[] = {
            "Frontier Raas", "Sacred Weaves", "Kalki Fashion", "Ritu Kumar"};

    private String colours_list[] = {
            "Red", "Bright Pink", "Light Pink", "Maroon", "White", "Gold"};

    private String fabric_list[] = {
            "Raw Silk", "Silk", "Organza", "Velvet", "Satin", "Chanderi"};

    private String style_list[] = {
            "Bridal Lehenga", "Engagement Lehenga", "Scallaped", "Pastel"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_browse);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        bottom_sheet = findViewById(R.id.bottom_sheet);
        mBehavior = BottomSheetBehavior.from(bottom_sheet);
        filter = findViewById(R.id.filter);
        msg_linear = findViewById(R.id.msg_linear);
        close_msg = findViewById(R.id.close_msg);

        showRecycler1();
        showRecycler2();
        showRecycler3();
        showRecycler4();

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });

        close_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg_linear.setVisibility(View.GONE);
            }
        });
    }

    private void showRecycler3() {

        recyclerView3 = findViewById(R.id.recyclerview3);

        linearLayoutManager = new GridLayoutManager(context, 2);
        trendingNowAdapter = new ShopBrowseAdapter(context);
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        recyclerView3.setAdapter(trendingNowAdapter);
        recyclerView3.setLayoutManager(linearLayoutManager);

    }

    private void showRecycler4() {
        recyclerView4 = findViewById(R.id.recyclerview4);

        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false);
        trendingNowAdapter = new ShopBrowseAdapter(context);
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        recyclerView4.setAdapter(trendingNowAdapter);
        recyclerView4.setLayoutManager(linearLayoutManager);
    }

    private void showRecycler1() {
        recyclerView1 = findViewById(R.id.recyclerview1);

        linearLayoutManager = new GridLayoutManager(context, 2);
        trendingNowAdapter = new ShopBrowseAdapter(context);
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        recyclerView1.setAdapter(trendingNowAdapter);
        recyclerView1.setLayoutManager(linearLayoutManager);

    }

    private void showRecycler2() {
        recyclerView2 = findViewById(R.id.recyclerview2);

        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false);
        trendingNowAdapter = new ShopBrowseAdapter(context);
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        recyclerView2.setAdapter(trendingNowAdapter);
        recyclerView2.setLayoutManager(linearLayoutManager);

    }

    private void showBottomSheetDialog() {
        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        final View view = getLayoutInflater().inflate(R.layout.filter_bottomsheet_layout, null);
        TextView clear_all = ((TextView) view.findViewById(R.id.clear_all));
        TextView close = ((TextView) view.findViewById(R.id.close));
        TextView apply_filter = ((TextView) view.findViewById(R.id.apply_filter));
        RecyclerView main_recyclerview = view.findViewById(R.id.main_recyclerview);
        sub_recyclerview = view.findViewById(R.id.sub_recyclerview);
        EditText search = view.findViewById(R.id.search);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog.dismiss();
            }
        });
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        subLinearlayoutmanager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        filterTypeAdapter = new FilterTypeAdapter(context, type_list);
        main_recyclerview.setAdapter(filterTypeAdapter);
        main_recyclerview.setLayoutManager(linearLayoutManager);

        filter_subType_adapter = new Filter_SubType_Adapter(context, outfit_list);
        sub_recyclerview.setAdapter(filter_subType_adapter);
        sub_recyclerview.setLayoutManager(subLinearlayoutmanager);

        main_recyclerview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), main_recyclerview, new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {

                        if(type_list[position].matches("Outfit Type")){

                            filter_subType_adapter = new Filter_SubType_Adapter(context, outfit_list);

                        }else if(type_list[position].matches("Occasion")){

                            filter_subType_adapter = new Filter_SubType_Adapter(context, occasion_list);

                        }else if(type_list[position].matches("Price")){

                            filter_subType_adapter = new Filter_SubType_Adapter(context, Price_list);

                        }else if(type_list[position].matches("City")){

                            filter_subType_adapter = new Filter_SubType_Adapter(context, city_list);

                        }else if(type_list[position].matches("Brand")){

                            filter_subType_adapter = new Filter_SubType_Adapter(context, brand_list);

                        }else if(type_list[position].matches("Colours")){

                            filter_subType_adapter = new Filter_SubType_Adapter(context, colours_list);

                        }else if(type_list[position].matches("Fabric")){

                            filter_subType_adapter = new Filter_SubType_Adapter(context, fabric_list);

                        }else if(type_list[position].matches("Style")){

                            filter_subType_adapter = new Filter_SubType_Adapter(context, style_list);

                        }

                        sub_recyclerview.setAdapter(filter_subType_adapter);
                        sub_recyclerview.setLayoutManager(subLinearlayoutmanager);
                        filter_subType_adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
        }));

        mBottomSheetDialog = new BottomSheetDialog(this);
        mBottomSheetDialog.setCancelable(false);
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