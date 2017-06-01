package com.example.ahmedetman.reviewsapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Ahmed Etman on 6/1/2017.
 */

public class NetworkUtils
{
    /**
     * checking if the network is available or not
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context)
    {
       try
       {
           ConnectivityManager connectivityManager
                   = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
           NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
           return activeNetworkInfo != null && activeNetworkInfo.isConnected();
       }
       catch (Exception e)
       {
           throw e;
       }
    }
}
