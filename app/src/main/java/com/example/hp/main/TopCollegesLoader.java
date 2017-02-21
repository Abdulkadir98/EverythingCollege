package com.example.hp.main;

import android.content.Context;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2/21/2017.
 */

public class TopCollegesLoader extends android.support.v4.content.AsyncTaskLoader {
    public TopCollegesLoader(Context context){
        super(context);
    }
    @Override
    public List<topHundred> loadInBackground() {
        try {


            String jsonResponse = HttpRequest.get("http://http://cskcecback.herokuapp.com/top25rankings.php?name=everythingcollegeadmin97")
                    .body();
        }
        catch (HttpRequest.HttpRequestException e){
            e.printStackTrace();
        }
        return null;
    }

    private List<topHundred> extractFromJSON(String response){
        ArrayList<topHundred> colleges = new ArrayList<>();
        if(TextUtils.isEmpty(response)){
            return null;
        }
        try {
            JSONArray rootJson = new JSONArray(response);
            for(int i=0; i<rootJson.length(); i++){
                JSONObject jsonObject = rootJson.getJSONObject(i);
                int rank = Integer.parseInt(jsonObject.getString("ranking"));
                String college = jsonObject.getString("college");

                colleges.add(new topHundred(rank, college ));
            }return colleges;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
