package com.example.hp.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import info.hoang8f.widget.FButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class PredicterFragment extends Fragment {
    private ArrayList<Double> testScores;
    private EditText enterScore;
    private FButton displayScore, displayPrediction;
    private static final String TAG = PredicterFragment.class.getSimpleName();
    private static final int CUT_OFF_JEE_MAIN = 100;
    private static final int CUT_OFF_BITS = 345;
    private static final int CUT_OFF_VIT = 60;
    private static final int CUT_OFF_JEE_ADVANCED = 75;
    private Spinner mListOfExams;
    ArrayList<String> examList;





    public PredicterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_predicter, container, false);
        enterScore = (EditText)rootView.findViewById(R.id.enter_score);
        displayScore = (FButton) rootView.findViewById(R.id.add_score_button);
        displayPrediction = (FButton) rootView.findViewById(R.id.show_score_prediction);
        mListOfExams = (Spinner)rootView.findViewById(R.id.spinner);

        examList = new ArrayList<>();
        examList.add("JEE Main");
        examList.add("JEE Advanced");
        examList.add("BITSAT");
        examList.add("VITEEE");


       ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, examList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mListOfExams.setAdapter(adapter);
        testScores = new ArrayList<Double>();



//            displayScore.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Double score = Double.parseDouble(enterScore.getText().toString().trim());
//                    if (score!=null && testScores.size()<5) {
//                        testScores.add(score);
//                        Log.i(TAG,"Score: " + testScores);
//                        enterScore.setText("");
//                        Toast.makeText(getContext(), "Added score", Toast.LENGTH_SHORT).show();
//
//
//                    }
//                    else {
//                        Toast.makeText(getContext(), "You can add only five scores", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//                     displayPrediction.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View view) {
//                         if(testScores!=null && testScores.size()==5) {
//                             enterScore.setText(Utility.predictionValue(testScores) + "");
//                         }
//                         else
//                         {
//                             Toast.makeText(getContext(), "Sorry! you haven't entered your scores",
//                                     Toast.LENGTH_SHORT).show();
//                         }
//
//    }
//});
        mListOfExams.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                parent.getItemAtPosition(position);
                switch (position) {
                    case 0:
                        testScores.clear();
                        enterScore.setText("");
                        predictScore(CUT_OFF_JEE_MAIN);
                        break;
                    case 1:
                        testScores.clear();
                        enterScore.setText("");

                        predictScore(CUT_OFF_JEE_ADVANCED);
                        break;
                    case 2:
                        testScores.clear();
                        enterScore.setText("");

                        predictScore(CUT_OFF_BITS);
                        break;
                    case 3:
                        testScores.clear();
                        enterScore.setText("");

                        predictScore(CUT_OFF_VIT);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid choice");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }


        });

       return rootView;
    }


    @Override
    public String toString() {
        return "PredicterFragment{" +
                "testScores=" + testScores +
                ", enterScore=" + enterScore +
                ", displayScore=" + displayScore +
                '}';
    }
    private void predictScore(final int cutOff){
        displayScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Double score = Double.parseDouble(enterScore.getText().toString().trim());
                if(score!=null) {
                    if (testScores.size() < 5) {
                        testScores.add(score);
                        Log.i(TAG, "Score: " + testScores);
                        enterScore.setText("");
                        Toast.makeText(getContext(), "Added score", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(getContext(), "You can add only five scores", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getContext(), "Please enter atleast one score", Toast.LENGTH_SHORT).show();
                }
            }
        });
        displayPrediction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(testScores!=null) {
                    double predictedScore = Utility.predictionValue(testScores);
                    enterScore.setText(predictedScore + "");
                    if(predictedScore>=cutOff){
                        Toast.makeText(getContext(), "Congrats! You have a great chance of entering", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getContext(),"Sorry! You must try harder", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getContext(), "Sorry! you haven't entered your scores",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
