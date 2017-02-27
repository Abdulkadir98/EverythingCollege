package com.example.hp.main;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

/**
 * Created by admin on 2/9/2017.
 */

public class examsAdapter extends ArrayAdapter<topHundred.Exams> {
    public examsAdapter(Activity context, ArrayList<topHundred.Exams> examsArrayAdapter){
        super(context,0, examsArrayAdapter);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.exam_list, parent, false);
        }
        topHundred.Exams exam = getItem(position);
        TextView examTextView = (TextView)listItemView.findViewById(R.id.exam_text_view);
        examTextView.setText(exam.getExam());
        examTextView.setTypeface(EasyFonts.caviarDreamsBold(getContext()));

        return listItemView;
    }
}
