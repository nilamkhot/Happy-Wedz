package com.dataversity.happywedz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dataversity.happywedz.R;
import com.dataversity.happywedz.adapter.CircularAdapter;
import com.dataversity.happywedz.adapter.ShortlistAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShortlistFragment extends Fragment {
   RecyclerView recyclerView;
   LinearLayoutManager linearLayoutManager;
   ShortlistAdapter shortlistAdapter;

    public ShortlistFragment() {
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
        View v= inflater.inflate(R.layout.shortlist_fragment, container, false);

        recyclerView = v.findViewById(R.id.recyclerview);

        linearLayoutManager = new GridLayoutManager(getContext(), 2);
        shortlistAdapter = new ShortlistAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        recyclerView.setAdapter(shortlistAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);


        return v;
    }

}