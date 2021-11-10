package com.dataversity.happywedz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataversity.happywedz.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ChildViewHolder> {

   // private List<FranchiseWasherResponsePojo> ChildItemList;
    Context context;

    // Constuctor
    public CategoryAdapter(Context context)
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_child_item, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int position)
    {
        // Create an instance of the ChildItem
        // class for the given position
        /*StoryListModel childItem = ChildItemList.get(position);
        // For the created instance, set title.
        // No need to set the image for
        // the ImageViews because we have
        // provided the source for the images
        // in the layout file itself
        String storyName;
        if (childItem.getTitle().length() >= 10) {
            storyName = childItem.getTitle().substring(0, 10)+ "...";
        } else {

            storyName = childItem.getTitle();

        }
        childViewHolder.ChildItemTitle.setText(storyName);

        childViewHolder.img_child_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, storyName, Toast.LENGTH_LONG).show();
            }
        });
*/
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

        TextView ChildItemTitle;
        ImageView img_child_item;

        ChildViewHolder(View itemView)
        {
            super(itemView);
           // ChildItemTitle = itemView.findViewById(R.id.child_item_title);
            //img_child_item = itemView.findViewById(R.id.img_child_item);
        }
    }
}

