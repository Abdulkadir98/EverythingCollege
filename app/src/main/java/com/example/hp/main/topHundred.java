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
    public static class Scholarship{
        private String fieldOfStudy, scholarshipTest;
        public Scholarship(String field, String test){
            fieldOfStudy = field;
            scholarshipTest = test;
        }
        public String getFieldOfStudy(){
            return fieldOfStudy;
        }
        public String getScholarshipTest(){
            return scholarshipTest;
        }

    }
    public static class Exams{
        private String exam;
        private Uri examUri;
        public Exams(String exam, Uri examUri){
            this.exam = exam;
            this.examUri = examUri;
        }
        public Uri getUrl(){
            return examUri;
        }
        public String getExam(){
            return exam;
        }
    }
}
