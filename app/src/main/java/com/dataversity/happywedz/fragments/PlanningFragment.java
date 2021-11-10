package com.dataversity.happywedz.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataversity.happywedz.InboxActivity;
import com.dataversity.happywedz.R;
import com.dataversity.happywedz.VendorShortlistActivity;
import com.dataversity.happywedz.MyChecklistActivity;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class PlanningFragment extends Fragment {
    TextView vendor_shortlist;
    CardView my_checklist;
    ImageView inbox_btn;

    public PlanningFragment() {
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
        View v= inflater.inflate(R.layout.planning_fragment, container, false);

        vendor_shortlist = v.findViewById(R.id.vendor_shortlist);
        my_checklist = v.findViewById(R.id.my_checklist);
        inbox_btn = v.findViewById(R.id.inbox_btn);

        vendor_shortlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), VendorShortlistActivity.class);
                startActivity(intent);
            }
        });

        my_checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyChecklistActivity.class);
                startActivity(intent);
            }
        });

        inbox_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), InboxActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

}