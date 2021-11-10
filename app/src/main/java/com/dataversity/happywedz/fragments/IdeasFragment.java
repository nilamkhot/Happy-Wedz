package com.dataversity.happywedz.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.dataversity.happywedz.IdeaSearchActivity;
import com.dataversity.happywedz.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class IdeasFragment extends Fragment {
    ViewPager viewPager;
    LinearLayout linearLayout;
    EditText edit_search;

    public IdeasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.idea_fragment, container, false);

        viewPager = v.findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        linearLayout = v.findViewById(R.id.search);
        edit_search = v.findViewById(R.id.edit_search);

        edit_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), IdeaSearchActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new IdeaPhotoFragment(), "Photos");
        adapter.addFragment(new IdeaStoryFragment(), "Stories");
        adapter.addFragment(new IdeaRealFragment(), "Real Weddings");
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