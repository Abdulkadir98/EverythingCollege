package com.example.hp.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class eligibilityFragment extends Fragment {

    int cutoff;
    EditText ed;
    public eligibilityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_eligibility, container, false);
        Button b= (Button)rootView.findViewById(R.id.button);
        ed=(EditText) rootView.findViewById(R.id.editText);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cutoff=Integer.parseInt(ed.getText().toString());
                Intent intent= new Intent(getActivity(),elgibilityAdapter.class);
                intent.putExtra("Number",cutoff);
                startActivity(intent);

            }
        });
        return rootView;
    }

}
