package com.dataversity.happywedz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dataversity.happywedz.R;
import com.dataversity.happywedz.adapter.IdeaStoryAdapter;
import com.dataversity.happywedz.adapter.PhotoAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class IdeaStoryFragment extends Fragment {
    RecyclerView recyclerview;
    LinearLayoutManager linearLayoutManager;
    IdeaStoryAdapter ideaStoryAdapter;

    public IdeaStoryFragment() {
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
        View v= inflater.inflate(R.layout.idea_story_fragment, container, false);

        showViewedRecycler(v);

        return v;
    }

    private void showViewedRecycler(View v) {
        recyclerview = v.findViewById(R.id.recyclerview);

        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ideaStoryAdapter = new IdeaStoryAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        recyclerview.setAdapter(ideaStoryAdapter);
        recyclerview.setLayoutManager(linearLayoutManager);
    }

}