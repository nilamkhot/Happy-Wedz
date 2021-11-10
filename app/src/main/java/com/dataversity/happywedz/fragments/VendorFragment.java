package com.dataversity.happywedz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.dataversity.happywedz.R;
import com.dataversity.happywedz.adapter.RealWeddingAdapter;
import com.dataversity.happywedz.adapter.VendorAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VendorFragment extends Fragment {
    RecyclerView vendor_child_recyclerview;
    LinearLayoutManager category_layoutManager;
    VendorAdapter vendorAdapter;

    Spinner spinner;
    String[] items = new String[] {"Select City", "Pune", "Mumbai"};

    public VendorFragment() {
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
        View v= inflater.inflate(R.layout.vendor_fragment, container, false);

        spinner = v.findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);

        vendor_child_recyclerview = v.findViewById(R.id.vendor_child_recyclerview);

        category_layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        vendorAdapter = new VendorAdapter(getContext(), new VendorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        vendor_child_recyclerview.setAdapter(vendorAdapter);
        vendor_child_recyclerview.setLayoutManager(category_layoutManager);

        return v;
    }

}