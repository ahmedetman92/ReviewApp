package com.example.ahmedetman.reviewsapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ahmedetman.reviewsapp.R;
import com.example.ahmedetman.reviewsapp.apis.ApiCallsManager;
import com.example.ahmedetman.reviewsapp.apis.ListingReviewsCallBack;
import com.example.ahmedetman.reviewsapp.models.Datum;
import com.example.ahmedetman.reviewsapp.ui.adapter.ReviewsRecyclerViewAdapter;
import com.example.ahmedetman.reviewsapp.utils.SharedPreferencesManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListingReviewsCallBack
{

    private RecyclerView reviewsRecyclerView;
    private ReviewsRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reviewsRecyclerView = (RecyclerView) findViewById(R.id.reviewsRecyclerView);
        ApiCallsManager.getInstance().getReviewsCall(this, this);
    }

    @Override
    public void onSuccess(ArrayList<Datum> data)
    {
        //in case if the user closed the activity and the network call still running
        if(isFinishing()||reviewsRecyclerView == null)return;
        SharedPreferencesManager.getInstance().setReviewsData(this, data);
        prepareReviewsRecyclerViewData(data);
    }

    @Override
    public void onOfflineMode()
    {
        //getting the cashed data while the device is offline
        ArrayList<Datum> data = SharedPreferencesManager.getInstance().getReviewsData(this);
        if(data != null)
            prepareReviewsRecyclerViewData(data);
        else
            Toast.makeText(this, R.string.offline_error_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFail()
    {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show();
    }

    /**
     * passing reviews data to adaptor and setting recycler view adaptor to reviews recycler view
     * @param data : list of reviews
     */
    private void prepareReviewsRecyclerViewData(ArrayList<Datum> data)
    {
        adapter = new ReviewsRecyclerViewAdapter(data);
        adapter.setOnReviewItemClickListener(new ReviewsRecyclerViewAdapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(Datum item)
            {
                Bundle  bundle = new Bundle();
                bundle.putSerializable(BUNDLE_REVIEW_OBJECT,item);
                Intent intent = new Intent(MainActivity.this, ReviewDetails.class);
                intent.putExtra(EXTRA_REVIEW_OBJECT,bundle);
                startActivity(intent);
            }
        });

        reviewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        reviewsRecyclerView.setAdapter(adapter);
    }


    final static String EXTRA_REVIEW_OBJECT = "EXTRA_REVIEW_OBJECT";
    final static String BUNDLE_REVIEW_OBJECT = "BUNDLE_REVIEW_OBJECT";

}
