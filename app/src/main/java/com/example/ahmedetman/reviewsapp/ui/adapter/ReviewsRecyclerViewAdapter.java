package com.example.ahmedetman.reviewsapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmedetman.reviewsapp.R;

/**
 * Created by Ahmed Etman on 5/31/2017.
 */

public class ReviewsRecyclerViewAdapter extends  RecyclerView.Adapter<ReviewsRecyclerViewAdapter.CustomViewHolder>
{
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder
    {
        TextView titleTextView, dateTextView, messageTextView, authorTextView;

        public CustomViewHolder(View view)
        {
            super(view);
            this.titleTextView = (TextView) view.findViewById(R.id.titleTextView);
            this.dateTextView = (TextView) view.findViewById(R.id.dateTextView);
            this.messageTextView = (TextView) view.findViewById(R.id.messageTextView);
            this.authorTextView = (TextView) view.findViewById(R.id.authorTextView);
        }
    }
}
