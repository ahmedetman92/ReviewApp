package com.example.ahmedetman.reviewsapp.apis;

import android.util.Log;

import com.example.ahmedetman.reviewsapp.models.Datum;
import com.example.ahmedetman.reviewsapp.models.ReviewResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmed Etman on 5/31/2017.
 */

public class ApiCallsManager
{


    private static ApiCallsManager instance = null;

    public static ApiCallsManager getInstance() {
        if(instance == null) {
            instance = new ApiCallsManager();
        }
        return instance;
    }

    public void getReviewsCall()
    {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ReviewResponse> call = apiService.getTourReviews();
        call.enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse>call, Response<ReviewResponse> response) {

                if(response.isSuccessful())
                {
                    ReviewResponse reviewResponse =  response.body();
                    ArrayList<Datum> reviewsList = new ArrayList<>();

                    reviewsList = (ArrayList<Datum>) reviewResponse.getData();

                    Datum datumObject = reviewsList.get(0);
                }
            }

            @Override
            public void onFailure(Call<ReviewResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("Test", t.getMessage());
            }
        });
    }
}
