package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.dataversity.happywedz.utils.Tools;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class IdeaSearchActivity extends Activity {
    Context context;
    String[] genres = {"Engagement Hairstyle", "Engagement gown", "Bridal entry songs", "Sangeet songs", "Bridal makeup in mumbai", "Bridal makeup in delhi"};

    int[][] states = new int[][] {
            new int[] { android.R.attr.state_enabled}, // enabled
            new int[] {-android.R.attr.state_enabled}, // disabled
            new int[] {-android.R.attr.state_checked}, // unchecked
            new int[] { android.R.attr.state_pressed}  // pressed
    };

    int[] colors = new int[] {
            Color.WHITE,
            Color.WHITE,
            Color.WHITE,
            Color.WHITE
    };

    int[] strokecolors = new int[] {
            Color.LTGRAY,
            Color.LTGRAY,
            Color.LTGRAY,
            Color.LTGRAY
    };


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_search);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        ChipGroup chipGroup = findViewById(R.id.chipgroup);

        ColorStateList myList = new ColorStateList(states, colors);
        ColorStateList strokeList = new ColorStateList(states, strokecolors);

        for(String genre : genres) {
            Chip chip = new Chip(context);
            chip.setChipBackgroundColor(myList);
            chip.setChipStrokeColor(strokeList);
            chip.setChipStrokeWidth(1f);
            chip.setTextColor(context.getResources().getColor(R.color.grey_40));
            chip.setText(genre);
            chipGroup.addView(chip);
        }

    }
}