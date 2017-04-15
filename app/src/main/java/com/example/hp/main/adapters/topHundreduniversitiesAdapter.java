package com.example.hp.main.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hp.main.R;
import com.example.hp.main.models.College;
import com.example.hp.main.models.topHundred;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11/24/2016.
 */
public class topHundreduniversitiesAdapter extends ArrayAdapter<College> {
    private ArrayList<College> top100 = new ArrayList<>();

    public topHundreduniversitiesAdapter(Activity context, ArrayList<College> top100){
        super(context, 0, top100);
        this.top100 = top100;
    }

//
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }
        College currentUniversity = getItem(position);
        TextView rankTextView = (TextView)listItemView.findViewById(R.id.rank_text_view);
        rankTextView.setText(currentUniversity.getRank()+"");
        rankTextView.setTypeface(EasyFonts.caviarDreamsBold(getContext()));
        rankTextView.setTextSize(18);

        TextView nameTextView = (TextView)listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentUniversity.getName());
        nameTextView.setTypeface(EasyFonts.caviarDreamsBold(getContext()));
        nameTextView.setTextSize(18);

        TextView placeTextView = (TextView)listItemView.findViewById(R.id.place_text_view);
        placeTextView.setText(currentUniversity.getCity());
        placeTextView.setTypeface(EasyFonts.caviarDreamsBold(getContext()));
        placeTextView.setTextSize(18);

        return listItemView;
    }
    public void setColleges(List<College> data) {
        if(data==null){
            return;
        }
        top100.addAll(data);
        notifyDataSetChanged();
    }
}

