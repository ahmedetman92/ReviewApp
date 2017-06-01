package com.example.ahmedetman.reviewsapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ahmedetman.reviewsapp.R;
import com.example.ahmedetman.reviewsapp.models.Datum;

import java.util.ArrayList;

/**
 * Created by Ahmed Etman on 5/31/2017.
 */

public class ReviewsRecyclerViewAdapter extends  RecyclerView.Adapter<ReviewsRecyclerViewAdapter.CustomViewHolder>
{


    OnItemClickListener onReviewItemClickListener;

    public void setOnReviewItemClickListener(OnItemClickListener onReviewItemClickListener)
    {
        this.onReviewItemClickListener = onReviewItemClickListener;
    }

    ArrayList<Datum> mReviewList;
    public ReviewsRecyclerViewAdapter(ArrayList<Datum> reviewsList)
    {
        this.mReviewList = reviewsList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position)
    {
        final Datum singleReview = mReviewList.get(position);
        holder.titleTextView.setText(singleReview.getTitle());
        holder.dateTextView.setText(singleReview.getDate());
        holder.messageTextView.setText(singleReview.getMessage());
        holder.authorTextView.setText(singleReview.getAuthor());
        holder.authorRating.setRating(Float.parseFloat(singleReview.getRating()));
        holder.itemContainer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onReviewItemClickListener.onItemClick(singleReview);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mReviewList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder
    {
        TextView titleTextView, dateTextView, messageTextView, authorTextView;
        RatingBar authorRating;
        View itemContainer;

        public CustomViewHolder(View view)
        {
            super(view);
            this.titleTextView = (TextView) view.findViewById(R.id.titleTextView);
            this.dateTextView = (TextView) view.findViewById(R.id.dateTextView);
            this.messageTextView = (TextView) view.findViewById(R.id.messageTextView);
            this.authorTextView = (TextView) view.findViewById(R.id.authorTextView);
            this.authorRating = (RatingBar) view.findViewById(R.id.authorRateRatingBar);
            this.itemContainer =  view.findViewById(R.id.itemContainer);

        }
    }


    public interface OnItemClickListener {
        void onItemClick(Datum item);
    }
}
