package com.dataversity.happywedz.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dataversity.happywedz.R;
import com.dataversity.happywedz.VenuesActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.ChildViewHolder> {

    // private List<FranchiseWasherResponsePojo> ChildItemList;
    Context context;
    private final OnItemClickListener listener;

    // Constuctor
    public VendorAdapter(Context context, OnItemClickListener listener)
    {
        // this.ChildItemList = childItemList;
        this.context = context;
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vendor_child_item, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int position)
    {
        childViewHolder.bind(position, listener);

        childViewHolder.back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VenuesActivity.class);
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
        return 6;
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    class ChildViewHolder extends RecyclerView.ViewHolder {

        TextView show_more;
        LinearLayout expanded_linear;
        ImageView back_img;

        ChildViewHolder(View itemView)
        {
            super(itemView);
            show_more = itemView.findViewById(R.id.show_more);
            expanded_linear = itemView.findViewById(R.id.expanded_linear);
            back_img = itemView.findViewById(R.id.back_img);
        }

        public void bind(final int position, final OnItemClickListener listener) {
            show_more.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    //listener.onItemClick(position);
                    if(expanded_linear.getVisibility() == View.VISIBLE){

                        Drawable img = context.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_down_24);
                        show_more.setCompoundDrawablesWithIntrinsicBounds(null, null, img, null);
                        expanded_linear.setVisibility(View.GONE);

                    }else {
                        Drawable img = context.getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_up_24);
                        show_more.setCompoundDrawablesWithIntrinsicBounds(null, null, img, null);
                        expanded_linear.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

    }
}

