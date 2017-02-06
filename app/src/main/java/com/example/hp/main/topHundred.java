package com.example.hp.main;

import android.net.Uri;

/**
 * Created by admin on 11/24/2016.
 */
public class topHundred {
    public String mUniversityName;
    public int mRank;
    public String mPlace;
    public Uri mUrl;
    public topHundred()
    {

    }


    public topHundred(int rank, String name, String place){
        mRank = rank;
        mUniversityName = name;
        mPlace = place;
    }

    public topHundred(int rank, String name, String place,Uri Url){
        mRank = rank;
        mUniversityName = name;
        mPlace = place;
        mUrl = Url;
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
        return mUrl;
    }
}
