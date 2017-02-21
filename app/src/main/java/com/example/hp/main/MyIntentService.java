package com.example.hp.main;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by admin on 2/15/2017.
 */

public class MyIntentService extends IntentService {
    public static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService(){
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        String response = HttpRequest.get("https://indian-colleges.p.mashape.com/v1/colleges").body();
        Log.i(TAG, "Response: " + response);

    }
}
