package com.dataversity.happywedz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataversity.happywedz.utils.Tools;
import com.zhpan.indicator.IndicatorView;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class OnBoardingActivity extends AppCompatActivity {
    Context context;
    private static final int MAX_STEP = 3;
    IndicatorView indicatorView;
    TextView skip;

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private String about_title_array[] = {
            "Lorem ipsum dolor sit amet consectetur adipiscing elit, sed",
            "Lorem ipsum dolor sit amet consectetur adipiscing elit, sed",
            "Lorem ipsum dolor sit amet consectetur adipiscing elit, sed"
    };
    private String about_description_array[] = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt u",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt u",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt u"
    };
    private int about_images_array[] = {
            R.drawable.wizard_1,
            R.drawable.wizard_2,
            R.drawable.wizard_3,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        skip = findViewById(R.id.skip);

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);

        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
               /* if (viewPager.getCurrentItem() == about_title_array.length - 1) {
                    btnNext.setText("Get Started");
                    login_layout.setVisibility(View.VISIBLE);
                } else {
                    btnNext.setText("Next");
                    login_layout.setVisibility(View.INVISIBLE);
                }*/
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

       skip.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, WelcomeActivity.class);
               startActivity(intent);
               finish();
           }
       });

    }


    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(final int position){
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.item_card_wizard, container, false);
            ((TextView) view.findViewById(R.id.title)).setText(about_title_array[position]);
            ((TextView) view.findViewById(R.id.description)).setText(about_description_array[position]);
            ((ImageView) view.findViewById(R.id.image)).setImageResource(about_images_array[position]);
            indicatorView = view.findViewById(R.id.indicator_view);

            indicatorView
                    .setSliderColor(getResources().getColor(R.color.light_pink), getResources().getColor(R.color.pink))
                    .setSliderWidth(getResources().getDimension(R.dimen.spacing_xxxlarge))
                    .setSliderHeight(getResources().getDimension(R.dimen.spacing_medium))
                    .setSlideMode(IndicatorSlideMode.WORM)
                    .setIndicatorStyle(IndicatorStyle.DASH)
                    .setSliderGap(0f)
                    .setupWithViewPager(viewPager);

            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return about_title_array.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }


}