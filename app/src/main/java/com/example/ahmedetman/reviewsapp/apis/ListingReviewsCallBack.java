package com.example.ahmedetman.reviewsapp.apis;

import com.example.ahmedetman.reviewsapp.models.Datum;

import java.util.ArrayList;

/**
 * Created by Ahmed Etman on 6/1/2017.
 */

public interface ListingReviewsCallBack extends NetworkCallBack<ArrayList<Datum>>
{

    /**
     * onOfflineMode indicates that there is no internet connection available
     */
    void onOfflineMode();
}
