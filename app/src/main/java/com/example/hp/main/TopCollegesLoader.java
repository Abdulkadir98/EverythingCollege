package com.example.hp.main;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2/21/2017.
 */

public class TopCollegesLoader extends android.support.v4.content.AsyncTaskLoader {
    ArrayList<topHundred> colleges = new ArrayList<>();
    private static final String TAG = TopCollegesLoader.class.getSimpleName();

    public TopCollegesLoader(Context context){
        super(context);
    }
    @Override
    public List<topHundred> loadInBackground() {
        try {


            String jsonResponse = HttpRequest.get("http://cskcecback.herokuapp.com/top25rankings.php?name=everythingcollegeadmin97")
                    .body();
            Log.i(TAG, "Response :" + jsonResponse);
            colleges = extractFromJSON(jsonResponse);
            return colleges;
        }
        catch (HttpRequest.HttpRequestException e){
            e.printStackTrace();
            return null;

        }
    }

    private ArrayList<topHundred> extractFromJSON(String response){
        if(TextUtils.isEmpty(response)){
            return null;
        }
        try {
            JSONArray rootJson = new JSONArray(response);
            for(int i=0; i<rootJson.length(); i++){
                JSONObject jsonObject = rootJson.getJSONObject(i);
                int rank = Integer.parseInt(jsonObject.getString("ranking"));
                String college = jsonObject.getString("college");
                String url = jsonObject.getString("url");
                String state = jsonObject.getString("state");

                colleges.add(new topHundred(rank, college, state, Uri.parse("http://" + url)));
            }return colleges;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
