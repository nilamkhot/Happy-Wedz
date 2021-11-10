package com.dataversity.happywedz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dataversity.happywedz.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VenuesAdapter extends RecyclerView.Adapter<VenuesAdapter.ChildViewHolder> {

   // private List<FranchiseWasherResponsePojo> ChildItemList;
    Context context;

    // Constuctor
    public VenuesAdapter(Context context)
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.venues_child_item, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int position)
    {


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
        return 6;
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    class ChildViewHolder extends RecyclerView.ViewHolder {

        TextView show_more;
        LinearLayout expanded_linear;

        ChildViewHolder(View itemView)
        {
            super(itemView);

        }



    }
}

