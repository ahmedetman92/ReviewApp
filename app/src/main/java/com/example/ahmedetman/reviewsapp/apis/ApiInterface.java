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
            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"
    })
    @GET("reviews.json?count=5&page=0&rating=0&sortBy=date_of_review&direction=DESC")
    Call<ReviewResponse> getTourReviews();
}
