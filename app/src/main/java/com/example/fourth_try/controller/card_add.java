package com.example.fourth_try.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fourth_try.R;

public class card_add extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //public enum KindOfCard{
    //    NOTHING, NORMAL, CALIENTE, QUESTION, CHALLENGE, VOTE;
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card_new);

        //TODO add spinner activity to show different fragments for different kinds of cards
        Spinner dropdown = findViewById(R.id.spinner_add_choice);
        dropdown.setAdapter(new ArrayAdapter<KindOfCard>(this, android.R.layout.simple_spinner_dropdown_item, KindOfCard.values()));
        dropdown.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int i, long id) {

        //TODO Change up the int i with ENUM
        switch (i) {
            case 0:
                Toast.makeText(getApplicationContext(), "Select something", Toast.LENGTH_SHORT).show();
                break;
            case 10:
                Toast.makeText(getApplicationContext(), "Normal", Toast.LENGTH_SHORT).show();
            case 2:
                Toast.makeText(getApplicationContext(), "Caliente", Toast.LENGTH_SHORT).show();
            case 3:
                Toast.makeText(getApplicationContext(),"Question", Toast.LENGTH_SHORT).show();
            case 4:
                Toast.makeText(getApplicationContext(),"Challenge", Toast.LENGTH_SHORT).show();
            case 5:
                Toast.makeText(getApplicationContext(), "Vote", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }


}
