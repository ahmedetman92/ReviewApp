package com.example.ahmedetman.reviewsapp.apis;

import com.example.ahmedetman.reviewsapp.models.ReviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Ahmed Etman on 5/31/2017.
 */

public interface ApiInterface
{


    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
            "User-Agent: "
    })
    @GET("reviews.json?count=5&page=0&rating=0&sortBy=date_of_review&direction=DESC")
    Call<ReviewResponse> getTourReviews();
}
