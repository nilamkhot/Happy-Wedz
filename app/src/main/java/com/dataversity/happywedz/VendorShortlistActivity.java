package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.dataversity.happywedz.fragments.FinalisedFragment;
import com.dataversity.happywedz.fragments.IdeaPhotoFragment;
import com.dataversity.happywedz.fragments.IdeaRealFragment;
import com.dataversity.happywedz.fragments.IdeaStoryFragment;
import com.dataversity.happywedz.fragments.IdeasFragment;
import com.dataversity.happywedz.fragments.ShortlistFragment;
import com.dataversity.happywedz.utils.Tools;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class VendorShortlistActivity extends AppCompatActivity {
    Context context;
    ViewPager viewPager;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_shortlist);

        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ShortlistFragment(), "Shortlists");
        adapter.addFragment(new FinalisedFragment(), "Finalised");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}