package com.example.hp.main;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 11/24/2016.
 */
public class topHundreduniversitiesAdapter extends ArrayAdapter<topHundred> {

    public topHundreduniversitiesAdapter(Activity context, ArrayList<topHundred> top100){
        super(context, 0, top100);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }
        topHundred currentUniversity = getItem(position);
        TextView rankTextView = (TextView)listItemView.findViewById(R.id.rank_text_view);
        rankTextView.setText(currentUniversity.getRank()+"");

        TextView nameTextView = (TextView)listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentUniversity.getUniversityName());

        TextView placeTextView = (TextView)listItemView.findViewById(R.id.place_text_view);
        placeTextView.setText(currentUniversity.getPlace());
        return listItemView;
    }
}

