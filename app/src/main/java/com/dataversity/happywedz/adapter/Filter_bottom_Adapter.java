package com.dataversity.happywedz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataversity.happywedz.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Filter_bottom_Adapter extends RecyclerView.Adapter<Filter_bottom_Adapter.ChildViewHolder> {

    String[] list;
    Context context;

    // Constuctor
    public Filter_bottom_Adapter(Context context, String[] list)
    {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_bottom_child_item, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int position)
    {
        // Create an instance of the ChildItem
        // class for the given position
        String childItem = list[position];
        childViewHolder.ChildItemTitle.setText(childItem);

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
        return list.length;
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    class ChildViewHolder extends RecyclerView.ViewHolder {

        CheckBox ChildItemTitle;

        ChildViewHolder(View itemView)
        {
            super(itemView);
             ChildItemTitle = itemView.findViewById(R.id.checkbox);
            //img_child_item = itemView.findViewById(R.id.img_child_item);
        }
    }
}

