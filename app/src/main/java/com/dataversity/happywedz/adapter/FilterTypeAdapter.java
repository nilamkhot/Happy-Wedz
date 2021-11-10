package com.dataversity.happywedz.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dataversity.happywedz.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FilterTypeAdapter extends RecyclerView.Adapter<FilterTypeAdapter.ChildViewHolder> {

    String[] list;
    Context context;
    private int row_index = 0;

    // Constuctor
    public FilterTypeAdapter(Context context, String[] list)
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_type_child_item, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int position)
    {
        // Create an instance of the ChildItem
        // class for the given position
        String childItem = list[position];
        childViewHolder.ChildItemTitle.setText(childItem);

        childViewHolder.ChildItemTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if(row_index==position){
            childViewHolder.ChildItemTitle.setTextColor(context.getResources().getColor(R.color.dark_pink));

        }
        else
        {
            childViewHolder.ChildItemTitle.setTextColor(context.getResources().getColor(R.color.black));
        }

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

        TextView ChildItemTitle;

        ChildViewHolder(View itemView)
        {
            super(itemView);
             ChildItemTitle = itemView.findViewById(R.id.title);
            //img_child_item = itemView.findViewById(R.id.img_child_item);
        }

    }
}

