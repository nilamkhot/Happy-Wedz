package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataversity.happywedz.adapter.GenieServiceAdapter;
import com.dataversity.happywedz.adapter.InboxAdapter;
import com.dataversity.happywedz.utils.Tools;
import com.zhpan.indicator.IndicatorView;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;

public class GenieServiceActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerview;
    LinearLayoutManager category_layoutManager;
    GenieServiceAdapter genieServiceAdapter;
    IndicatorView indicatorView;
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    IndicatorView indicatorView2;
    private ViewPager viewPager2;
    private MyViewPagerAdapter2 myViewPagerAdapter2;

    private String about_title_array[] = {
            "Send Requirements",
            "Get availability and 1st quotes",
            "Request HappyWedz Best Price"
    };

    private int about_images_array[] = {
            R.drawable.ic_baseline_checklist_24,
            R.drawable.ic_baseline_checklist_24,
            R.drawable.ic_baseline_checklist_24,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genie_service);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        recyclerview = findViewById(R.id.recyclerview);
        category_layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        genieServiceAdapter = new GenieServiceAdapter(context);
        // and adapter for items
        // of the parent recyclerview
        recyclerview.setAdapter(genieServiceAdapter);
        recyclerview.setLayoutManager(category_layoutManager);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);

        indicatorView = findViewById(R.id.indicator_view);

        indicatorView
                .setSliderColor(getResources().getColor(R.color.light_pink), getResources().getColor(R.color.pink))
                .setSliderWidth(getResources().getDimension(R.dimen.spacing_middle))
                .setSliderHeight(getResources().getDimension(R.dimen.spacing_middle))
                .setSlideMode(IndicatorSlideMode.NORMAL)
                .setIndicatorStyle(IndicatorStyle.CIRCLE)
                .setupWithViewPager(viewPager);

        viewPager2 = (ViewPager) findViewById(R.id.view_pager2);
        myViewPagerAdapter2 = new MyViewPagerAdapter2();
        viewPager2.setAdapter(myViewPagerAdapter2);

        indicatorView2 = findViewById(R.id.indicator_view2);

        indicatorView2
                .setSliderColor(getResources().getColor(R.color.light_pink), getResources().getColor(R.color.pink))
                .setSliderWidth(getResources().getDimension(R.dimen.spacing_middle))
                .setSliderHeight(getResources().getDimension(R.dimen.spacing_middle))
                .setSlideMode(IndicatorSlideMode.NORMAL)
                .setIndicatorStyle(IndicatorStyle.CIRCLE)
                .setupWithViewPager(viewPager2);



    }

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

            View view = layoutInflater.inflate(R.layout.genie_service_card_wizard, container, false);
            ((TextView) view.findViewById(R.id.title)).setText(about_title_array[position]);
            ((ImageView) view.findViewById(R.id.image)).setImageResource(about_images_array[position]);

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


    public class MyViewPagerAdapter2 extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter2() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.genie_service2_card_wizard, container, false);

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