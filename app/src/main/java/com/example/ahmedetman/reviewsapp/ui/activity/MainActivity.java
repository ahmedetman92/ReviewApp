package com.example.ahmedetman.reviewsapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.ahmedetman.reviewsapp.R;
import com.example.ahmedetman.reviewsapp.apis.ApiCallsManager;
import com.example.ahmedetman.reviewsapp.ui.adapter.ReviewsRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reviewsRecyclerView;
    private ReviewsRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiCallsManager.getInstance().getReviewsCall();
        reviewsRecyclerView = (RecyclerView) findViewById(R.id.reviewsRecyclerView);
    }
}
