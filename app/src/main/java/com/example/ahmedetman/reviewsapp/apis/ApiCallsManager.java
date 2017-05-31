package com.example.ahmedetman.reviewsapp.apis;

import android.util.Log;

import com.example.ahmedetman.reviewsapp.models.ReviewResponse;

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

                if (response.body()!= null)
                    Log.d("Test", response.body().toString());
            }

            @Override
            public void onFailure(Call<ReviewResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("Test", t.getMessage());
            }
        });
    }
}
