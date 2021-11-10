package com.dataversity.happywedz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dataversity.happywedz.adapter.Filter_bottom_Adapter;
import com.dataversity.happywedz.utils.Tools;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class IdeaPhotoDetailActivity extends Activity {
    Context context;
    private BottomSheetBehavior mBehavior;

    String[] genres = {"Engagement Hairstyle", "Engagement gown", "Bridal entry songs", "Sangeet songs", "Bridal makeup in mumbai", "Bridal makeup in delhi"};

    int[][] states = new int[][] {
            new int[] { android.R.attr.state_enabled}, // enabled
            new int[] {-android.R.attr.state_enabled}, // disabled
            new int[] {-android.R.attr.state_checked}, // unchecked
            new int[] { android.R.attr.state_pressed}  // pressed
    };

    int[] colors = new int[] {
            Color.parseColor("#F263AE"),
            Color.parseColor("#F263AE"),
            Color.parseColor("#F263AE"),
            Color.parseColor("#F263AE")
    };

    int[] strokecolors = new int[] {
            Color.WHITE,
            Color.WHITE,
            Color.WHITE,
            Color.WHITE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_photo_detail);

        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        showBottomSheetDialog();

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showBottomSheetDialog() {
        // get the bottom sheet view
        LinearLayout llBottomSheet = findViewById(R.id.bottom_sheet);

        // init the bottom sheet behavior
        mBehavior = BottomSheetBehavior.from(llBottomSheet);

        ChipGroup chipGroup = findViewById(R.id.chipgroup);

        ColorStateList myList = new ColorStateList(states, strokecolors);
        ColorStateList strokeList = new ColorStateList(states, colors);

        for(String genre : genres) {
            Chip chip = new Chip(context);
            chip.setChipBackgroundColor(myList);
            chip.setChipStrokeColor(strokeList);
            chip.setChipStrokeWidth(1f);
            chip.setTextColor(context.getResources().getColor(R.color.pink));
            chip.setText(genre);
            chipGroup.addView(chip);
        }

        // change the state of the bottom sheet
        mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mBehavior.setHideable(false);

        // set callback for changes
        mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

}