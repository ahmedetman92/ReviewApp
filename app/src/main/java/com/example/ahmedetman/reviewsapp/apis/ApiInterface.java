package com.example.ahmedetman.reviewsapp.apis;

import com.example.ahmedetman.reviewsapp.models.ReviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ahmed Etman on 5/31/2017.
 */

public interface ApiInterface
{
    @GET("reviews.json")
    Call<ReviewResponse> getTourReviews();
}
