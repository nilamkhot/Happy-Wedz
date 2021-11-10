package com.dataversity.happywedz.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.dataversity.happywedz.MessageActivity;
import com.dataversity.happywedz.R;
import com.dataversity.happywedz.UserActivity;
import com.dataversity.happywedz.VendorShortlistActivity;
import com.dataversity.happywedz.adapter.CategoryAdapter;
import com.dataversity.happywedz.adapter.InterestingAdapter;
import com.dataversity.happywedz.adapter.PhotographerAdapter;
import com.dataversity.happywedz.adapter.RealWeddingAdapter;
import com.dataversity.happywedz.adapter.ServiceAdapter;
import com.dataversity.happywedz.adapter.TrendingAdapter;
import com.dataversity.happywedz.adapter.VenuesAdapter;
import com.dataversity.happywedz.adapter.VideoAdapter;
import com.dataversity.happywedz.adapter.WeddingIdeasAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {
    RecyclerView categories_child_recyclerview, venues_child_recyclerview, photographer_child_recyclerview, trending_child_recyclerview;
    RecyclerView video_child_recyclerview, services_child_recyclerview,ideas_child_recyclerview,interesting_child_recyclerview,real_wedding_child_recyclerview;
    LinearLayoutManager category_layoutManager;
    CategoryAdapter categoryAdapter;
    VenuesAdapter venuesAdapter;
    PhotographerAdapter photographerAdapter;
    TrendingAdapter trendingAdapter;
    VideoAdapter videoAdapter;
    ServiceAdapter serviceAdapter;
    WeddingIdeasAdapter weddingIdeasAdapter;
    InterestingAdapter interestingAdapter;
    RealWeddingAdapter realWeddingAdapter;
    ImageButton user_btn, message;

    Spinner spinner;
    String[] items = new String[] {"Select City", "Pune", "Mumbai"};

    public HomeFragment() {
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
        View v= inflater.inflate(R.layout.home_fragment, container, false);

        spinner = v.findViewById(R.id.spinner);
        user_btn = v.findViewById(R.id.user_btn);
        message = v.findViewById(R.id.message);

        user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UserActivity.class);
                startActivity(intent);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageActivity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);

        ShowCategoryList(v);
        ShowVenuesList(v);
        ShowPhotographersList(v);
        ShowTrendingsList(v);
        ShowVideoList(v);
        ShowServiceList(v);
        ShowIdeasList(v);
        ShowInterestingList(v);
        ShowRealWeddingList(v);

        return v;
    }

    private void ShowRealWeddingList(View v) {

        real_wedding_child_recyclerview = v.findViewById(R.id.real_wedding_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        realWeddingAdapter = new RealWeddingAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        real_wedding_child_recyclerview.setAdapter(realWeddingAdapter);
        real_wedding_child_recyclerview.setLayoutManager(category_layoutManager);

    }

    private void ShowInterestingList(View v) {
        interesting_child_recyclerview = v.findViewById(R.id.interesting_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        interestingAdapter = new InterestingAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        interesting_child_recyclerview.setAdapter(interestingAdapter);
        interesting_child_recyclerview.setLayoutManager(category_layoutManager);

    }

    private void ShowIdeasList(View v) {
        ideas_child_recyclerview = v.findViewById(R.id.ideas_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        weddingIdeasAdapter = new WeddingIdeasAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        ideas_child_recyclerview.setAdapter(weddingIdeasAdapter);
        ideas_child_recyclerview.setLayoutManager(category_layoutManager);

    }

    private void ShowServiceList(View v) {
        services_child_recyclerview = v.findViewById(R.id.services_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        serviceAdapter = new ServiceAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        services_child_recyclerview.setAdapter(serviceAdapter);
        services_child_recyclerview.setLayoutManager(category_layoutManager);

    }

    private void ShowVideoList(View v) {
        video_child_recyclerview = v.findViewById(R.id.video_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        videoAdapter = new VideoAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        video_child_recyclerview.setAdapter(videoAdapter);
        video_child_recyclerview.setLayoutManager(category_layoutManager);

    }

    private void ShowTrendingsList(View v) {

        trending_child_recyclerview = v.findViewById(R.id.trending_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        trendingAdapter = new TrendingAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        trending_child_recyclerview.setAdapter(trendingAdapter);
        trending_child_recyclerview.setLayoutManager(category_layoutManager);

    }

    private void ShowPhotographersList(View v) {

        photographer_child_recyclerview = v.findViewById(R.id.photographer_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        photographerAdapter = new PhotographerAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        photographer_child_recyclerview.setAdapter(photographerAdapter);
        photographer_child_recyclerview.setLayoutManager(category_layoutManager);

    }

    private void ShowVenuesList(View v) {

        venues_child_recyclerview = v.findViewById(R.id.venues_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        venuesAdapter = new VenuesAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        venues_child_recyclerview.setAdapter(venuesAdapter);
        venues_child_recyclerview.setLayoutManager(category_layoutManager);

    }

    private void ShowCategoryList(View v) {

        categories_child_recyclerview = v.findViewById(R.id.categories_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryAdapter = new CategoryAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        categories_child_recyclerview.setAdapter(categoryAdapter);
        categories_child_recyclerview.setLayoutManager(category_layoutManager);

    }

}