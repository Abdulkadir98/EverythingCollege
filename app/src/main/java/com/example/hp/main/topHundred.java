package com.example.hp.main;

import android.net.Uri;

/**
 * Created by admin on 11/24/2016.
 */
public class topHundred {
    private String mUniversityName;
    private int mRank;
    private String mPlace;
    private Uri mWebsiteUrl;
    public topHundred(int rank, String name, String place){
        mRank = rank;
        mUniversityName  = name;
        mPlace = place;
    }

    public topHundred(int rank, String name, String place, Uri url){
        mRank = rank;
        mUniversityName = name;
        mPlace = place;
        mWebsiteUrl = url;
    }

    public int  getRank(){
        return mRank;
    }
    public String getUniversityName(){
        return mUniversityName;
    }
    public String getPlace(){
        return mPlace;
    }
    public Uri getUrl(){
        return mWebsiteUrl;
    }
}
