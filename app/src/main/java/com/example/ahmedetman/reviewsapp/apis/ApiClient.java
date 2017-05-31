package com.example.ahmedetman.reviewsapp.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ahmed Etman on 5/31/2017.
 */

public class ApiClient
{

        public static final String BASE_URL =
            "https://www.getyourguide.com/berlin-l17/tempelhof-2-hour-airport-history-tour-berlin-airlift-more-t23776/";
        private static Retrofit retrofit = null;

        public static Retrofit getClient()
        {
            if (retrofit == null)
            {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
}
