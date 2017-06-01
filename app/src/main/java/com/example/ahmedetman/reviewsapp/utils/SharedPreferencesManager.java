package com.example.ahmedetman.reviewsapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ahmedetman.reviewsapp.models.Datum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Ahmed Etman on 6/1/2017.
 */

public class SharedPreferencesManager
{

    private static SharedPreferencesManager instance = null;

    public static SharedPreferencesManager getInstance() {
        if(instance == null) {
            instance = new SharedPreferencesManager();
        }
        return instance;
    }

    public static final String PREFS_NAME = "DataToBeCashed";
    public static final String PREF_KEY_NAME = "ReviewsList";
    SharedPreferences reviewsSharedPref;

    /**
     * saving list of reviews to shared preferences
     * @param context
     * @param data
     */
    public void setReviewsData(Context context, ArrayList<Datum> data)
    {
        Gson gson = new Gson();
        String json = gson.toJson(data);

         reviewsSharedPref = context.getSharedPreferences(PREFS_NAME, context.MODE_PRIVATE);

        // Writing data to SharedPreferences
        SharedPreferences.Editor editor = reviewsSharedPref.edit();
        editor.putString(PREF_KEY_NAME, json);
        editor.commit();

    }

    /**
     * getting the cashed data from Preferences
     * @return list of review
     */
    public ArrayList<Datum> getReviewsData(Context context)
    {
        Type token = new TypeToken<ArrayList<Datum>>() {}.getType();

        // Reading from SharedPreferences
        reviewsSharedPref = context.getSharedPreferences(PREFS_NAME, context.MODE_PRIVATE);
        String listAsJsonString = reviewsSharedPref.getString(PREF_KEY_NAME, null);
        if (listAsJsonString != null)
        {
            return new Gson().fromJson(listAsJsonString, token);
        }

        return null;
    }








}
