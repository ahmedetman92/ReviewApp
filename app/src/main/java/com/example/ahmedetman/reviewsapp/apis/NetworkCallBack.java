package com.example.ahmedetman.reviewsapp.apis;

/**
 * Created by Ahmed Etman on 6/1/2017.
 */
public interface NetworkCallBack<T>
{
    /**
     * onSuccess indicates that the request success and returns list of data
     * @param data
     */
    void onSuccess(T data);

    /**
     * onFail indicates that the request failed
     */
    void onFail();
}
