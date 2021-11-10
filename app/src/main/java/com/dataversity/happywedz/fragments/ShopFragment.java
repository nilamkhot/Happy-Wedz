package com.dataversity.happywedz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dataversity.happywedz.R;
import com.dataversity.happywedz.adapter.CircularAdapter;
import com.dataversity.happywedz.adapter.FunctionAdapter;
import com.dataversity.happywedz.adapter.OutfitAdapter;
import com.dataversity.happywedz.adapter.RealWeddingAdapter;
import com.dataversity.happywedz.adapter.TrendingNowAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShopFragment extends Fragment {
    RecyclerView outfit_recyclerview,function_child_recyclerview,trending_child_recyclerview,circular_child_recyclerview;
    LinearLayoutManager category_layoutManager;
    OutfitAdapter outfitAdapter;
    FunctionAdapter functionAdapter;
    TrendingNowAdapter trendingNowAdapter;
    CircularAdapter circularAdapter;

    public ShopFragment() {
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
        View v= inflater.inflate(R.layout.shop_fragment, container, false);

        ShowOutfit(v);
        ShowFunction(v);
        ShowTrending(v);
        ShowCircular(v);

        return v;
    }

    private void ShowCircular(View v) {

        circular_child_recyclerview = v.findViewById(R.id.circular_child_recyclerview);

        category_layoutManager = new GridLayoutManager(getContext(), 2);
        circularAdapter = new CircularAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        circular_child_recyclerview.setAdapter(circularAdapter);
        circular_child_recyclerview.setLayoutManager(category_layoutManager);


    }

    private void ShowTrending(View v) {

        trending_child_recyclerview = v.findViewById(R.id.trending_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        trendingNowAdapter = new TrendingNowAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        trending_child_recyclerview.setAdapter(trendingNowAdapter);
        trending_child_recyclerview.setLayoutManager(category_layoutManager);

    }

    private void ShowFunction(View v) {
        function_child_recyclerview = v.findViewById(R.id.function_child_recyclerview);

        category_layoutManager = new GridLayoutManager(getContext(), 2);
        functionAdapter = new FunctionAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        function_child_recyclerview.setAdapter(functionAdapter);
        function_child_recyclerview.setLayoutManager(category_layoutManager);

    }

    private void ShowOutfit(View v) {

        outfit_recyclerview = v.findViewById(R.id.outfit_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        outfitAdapter = new OutfitAdapter(getContext());
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        outfit_recyclerview.setAdapter(outfitAdapter);
        outfit_recyclerview.setLayoutManager(category_layoutManager);

    }

}