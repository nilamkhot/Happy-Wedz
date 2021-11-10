package com.dataversity.happywedz;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.dataversity.happywedz.fragments.TellUsFragment;
import com.dataversity.happywedz.fragments.WeddingBudgetFragment;
import com.dataversity.happywedz.fragments.WeddingCityFragment;
import com.dataversity.happywedz.fragments.WeddingDateFragment;
import com.dataversity.happywedz.utils.Tools;
import com.zhpan.indicator.IndicatorView;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;

public class TellUsActivity extends FragmentActivity {
    ViewPager pager;
    IndicatorView indicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_us);

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pager = (ViewPager) findViewById(R.id.viewPager);
        indicatorView = findViewById(R.id.indicator_view);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        indicatorView
                .setSliderColor(getResources().getColor(R.color.light_pink), getResources().getColor(R.color.pink))
                .setSliderWidth(getResources().getDimension(R.dimen.spacing_xmlarge))
                .setSliderHeight(getResources().getDimension(R.dimen.spacing_medium))
                .setSlideMode(IndicatorSlideMode.WORM)
                .setIndicatorStyle(IndicatorStyle.DASH)
                .setupWithViewPager(pager);

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return TellUsFragment.newInstance("FirstFragment, Instance 1");
                case 1: return WeddingDateFragment.newInstance("SecondFragment, Instance 1");
                case 2: return WeddingCityFragment.newInstance("ThirdFragment, Instance 1");
                case 3: return WeddingBudgetFragment.newInstance("ThirdFragment, Instance 2");
                default: return WeddingBudgetFragment.newInstance("FourthFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }*/

}