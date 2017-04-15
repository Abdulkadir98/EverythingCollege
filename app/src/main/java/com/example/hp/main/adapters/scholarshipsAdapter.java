package com.example.hp.main.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hp.main.R;
import com.example.hp.main.models.topHundred;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

/**
 * Created by admin on 2/7/2017.
 */

public class scholarshipsAdapter extends ArrayAdapter<topHundred.Scholarship> {
    public scholarshipsAdapter(Activity context, ArrayList<topHundred.Scholarship> scholarships){
        super(context, 0, scholarships);
    }
//
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_scholarship, parent, false);
        }

            topHundred.Scholarship scholarship = getItem(position);
            TextView scholarshipExam = (TextView)listItemView.findViewById(R.id.scholarship_exams);
            scholarshipExam.setText(scholarship.getScholarshipTest());
        scholarshipExam.setTypeface(EasyFonts.caviarDreamsBold(getContext()));

            return listItemView;

        }

    }

