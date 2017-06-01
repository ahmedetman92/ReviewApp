package com.example.ahmedetman.reviewsapp.apis;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.ahmedetman.reviewsapp.models.Datum;
import com.example.ahmedetman.reviewsapp.models.ReviewResponse;
import com.example.ahmedetman.reviewsapp.utils.NetworkUtils;

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

    public static ApiCallsManager getInstance()
    {
        if (instance == null)
        {
            instance = new ApiCallsManager();
        }
        return instance;
    }

    /**
     * getting the reviews list
     * @param context
     * @param listingReviewsCallBack
     */
    public void getReviewsCall(Context context, final ListingReviewsCallBack listingReviewsCallBack)
    {
        if(NetworkUtils.isNetworkAvailable(context))
        {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call<ReviewResponse> call = apiService.getTourReviews();
            call.enqueue(new Callback<ReviewResponse>()
            {
                @Override
                public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response)
                {
                    if (response.isSuccessful())
                    {
                        ReviewResponse reviewResponse = response.body();
                        listingReviewsCallBack.onSuccess((ArrayList<Datum>) reviewResponse.getData());
                    }
                    else
                    {
                        listingReviewsCallBack.onFail();
                    }
                }

                @Override
                public void onFailure(Call<ReviewResponse> call, Throwable t)
                {
                    listingReviewsCallBack.onFail();
                }
            });
        }
        else
        {
            listingReviewsCallBack.onOfflineMode();
        }
    }


    /**
     * posting new review
     * @param rateValue
     * @param message
     * @param title
     * @param networkCallBack
     */
    public void postNewReview(final float rateValue, final String message,
                              final String title,
                              final  NetworkCallBack<Datum> networkCallBack)
    {
       final Handler handler = new Handler(Looper.getMainLooper());
       new Thread(new Runnable()
       {
           @Override
           public void run()
           {
              try{ Thread.sleep(2000);}catch (Exception e){/**/}
               handler.post(new Runnable()
               {
                   @Override
                   public void run()
                   {
                       Datum postingResponse = new Datum();
                       postingResponse.setTitle(title);
                       postingResponse.setTitle(message);
                       postingResponse.setRating(String.valueOf(rateValue));
                       networkCallBack.onSuccess(new Datum());
                   }
               });
           }
       }).start();
    }
}
