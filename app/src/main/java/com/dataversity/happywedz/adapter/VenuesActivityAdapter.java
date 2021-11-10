package com.dataversity.happywedz.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dataversity.happywedz.R;
import com.dataversity.happywedz.VenueDetailActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VenuesActivityAdapter extends RecyclerView.Adapter<VenuesActivityAdapter.ChildViewHolder> {

   // private List<FranchiseWasherResponsePojo> ChildItemList;
    Context context;

    // Constuctor
    public VenuesActivityAdapter(Context context)
    {
      // this.ChildItemList = childItemList;
        this.context = context;

    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.venues_activity_child_item, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int position)
    {
        childViewHolder.linear_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VenueDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {

        // This method returns the number
        // of items we have added
        // in the ChildItemList
        // i.e. the number of instances
        // of the ChildItemList
        // that have been created
      /*  return ChildItemList.size();*/
        return 4;
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    class ChildViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linear_back;
        ImageView img_child_item;

        ChildViewHolder(View itemView)
        {
            super(itemView);
            linear_back = itemView.findViewById(R.id.linear_back);
            //img_child_item = itemView.findViewById(R.id.img_child_item);
        }
    }
}

