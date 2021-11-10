package com.dataversity.happywedz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dataversity.happywedz.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FrequentlyQuestionAdapter extends RecyclerView.Adapter<FrequentlyQuestionAdapter.ChildViewHolder> {

    String[] que_array;
    String[] ans_array;
    Context context;
    private int row_index = 0;

    // Constuctor
    public FrequentlyQuestionAdapter(Context context, String[] que_array, String[] ans_array)
    {
        this.que_array = que_array;
        this.ans_array = ans_array;
        this.context = context;
    }


    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frequently_que_child_item, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int position)
    {
        // Create an instance of the ChildItem
        // class for the given position
        String que = que_array[position];
        String ans = ans_array[position];
        childViewHolder.ChildItemTitle.setText(que);
        childViewHolder.ans.setText(ans);

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
        return que_array.length;
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    class ChildViewHolder extends RecyclerView.ViewHolder {

        TextView ChildItemTitle,ans;

        ChildViewHolder(View itemView)
        {
            super(itemView);
             ChildItemTitle = itemView.findViewById(R.id.title);
             ans = itemView.findViewById(R.id.ans);
        }

    }
}

