package com.dataversity.happywedz.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dataversity.happywedz.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchCityAdapter extends RecyclerView.Adapter<SearchCityAdapter.ChildViewHolder> {

   // private List<FranchiseWasherResponsePojo> ChildItemList;
    Context context;
    String[] list;
    private final OnItemClickListener listener;
    private int row_index = -1;

    // Constuctor
    public SearchCityAdapter(Context context, String[] list, OnItemClickListener listener)
    {
      // this.ChildItemList = childItemList;
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_city_child_item, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int position)
    {
        // Create an instance of the ChildItem
        String childItem = list[position];
        childViewHolder.ChildItemTitle.setText(childItem);

        //childViewHolder.bind(position, listener);

        childViewHolder.back_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if(row_index==position){
            childViewHolder.ChildItemTitle.setTextColor(context.getResources().getColor(R.color.white));
            childViewHolder.back_linear.setBackgroundColor(context.getResources().getColor(R.color.pink));
            childViewHolder.select_loc.setVisibility(View.VISIBLE);
        }
        else
        {
            childViewHolder.ChildItemTitle.setTextColor(context.getResources().getColor(R.color.black));
            childViewHolder.back_linear.setBackgroundColor(context.getResources().getColor(R.color.white));
            childViewHolder.select_loc.setVisibility(View.GONE);
        }

        childViewHolder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).finish();
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
        return list.length;
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    class ChildViewHolder extends RecyclerView.ViewHolder {

        TextView ChildItemTitle,select_loc;
        LinearLayout back_linear;
        ImageView next;

        ChildViewHolder(View itemView)
        {
            super(itemView);
            ChildItemTitle = itemView.findViewById(R.id.city_name);
            select_loc = itemView.findViewById(R.id.select_loc);
            back_linear = itemView.findViewById(R.id.back_linear);
            next = itemView.findViewById(R.id.next);
        }

      /*  public void bind(final int position, final OnItemClickListener listener) {
            back_linear.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    //listener.onItemClick(position);



                }
            });
        }*/

    }
}

