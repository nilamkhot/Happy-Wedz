package com.dataversity.happywedz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dataversity.happywedz.R;
import com.dataversity.happywedz.adapter.PhotoAdapter;
import com.dataversity.happywedz.adapter.PhotographerAdapter;
import com.dataversity.happywedz.adapter.TrendingAdapter;
import com.dataversity.happywedz.adapter.TrendingNowAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class IdeaPhotoFragment extends Fragment {
    RecyclerView recyclerview;
    LinearLayoutManager linearLayoutManager;
    PhotoAdapter photoAdapter;

    public IdeaPhotoFragment() {
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
        View v= inflater.inflate(R.layout.idea_photo_fragment, container, false);

        showViewedRecycler(v);


        return v;
    }

    private void showViewedRecycler(View v) {
        recyclerview = v.findViewById(R.id.recyclerview);

        linearLayoutManager = new GridLayoutManager(getContext(), 2);
        photoAdapter = new PhotoAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        recyclerview.setAdapter(photoAdapter);
        recyclerview.setLayoutManager(linearLayoutManager);
    }

}