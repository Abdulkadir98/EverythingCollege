package com.example.hp.main;

/**
 * Created by admin on 11/24/2016.
 */
public class topHundred {
    private String mUniversityName;
    private int mRank;
    private String mPlace;

    public topHundred(int rank, String name, String place){
        mRank = rank;
        mUniversityName = name;
        mPlace = place;
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
}
