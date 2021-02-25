package com.example.fourth_try.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fourth_try.R;
import com.example.fourth_try.view.fragment_blank;
import com.example.fourth_try.view.fragment_caliente;
import com.example.fourth_try.view.fragment_challenge;
import com.example.fourth_try.view.fragment_normal;
import com.example.fourth_try.view.fragment_question;
import com.example.fourth_try.view.fragment_vote;

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

        changeFragment(i);

        /**
         * Case 0: Nothing
         * Case 1: Normal
         * Case 2: Caliente
         * Case 3: Question
         * Case 4: Challenge
         * Case 5: Vote
         */
/**
        switch (i) {
            case 0:
                Toast.makeText(getApplicationContext(), "Select something", Toast.LENGTH_SHORT).show();
                changeFragment(i);
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "Normal", Toast.LENGTH_SHORT).show();
                changeFragment(i);
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "Caliente", Toast.LENGTH_SHORT).show();
                changeFragment(i);
                break;
            case 3:
                Toast.makeText(getApplicationContext(),"Question", Toast.LENGTH_SHORT).show();
                changeFragment(i);
                break;
            case 4:
                Toast.makeText(getApplicationContext(),"Challenge", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(getApplicationContext(), "Vote", Toast.LENGTH_SHORT).show();
                break;
        }*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Auto-generated method stub
    }

    public void changeFragment(int position){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        /**
         * Case 0: Nothing
         * Case 1: Normal
         * Case 2: Caliente
         * Case 3: Question
         * Case 4: Challenge
         * Case 5: Vote
         */
        switch(position){
            case 0:
                Toast.makeText(getApplicationContext(), "Select something", Toast.LENGTH_SHORT).show();
                fragment_blank blankfrag =new fragment_blank();
                ft.replace(R.id.fragment_questions, blankfrag).commit();
                break;
            case 1:
                fragment_normal normalfrag = new fragment_normal();
                ft.replace(R.id.fragment_questions, normalfrag).commit();
                break;
            case 2:
                fragment_caliente calfrag = new fragment_caliente();
                ft.replace(R.id.fragment_questions, calfrag).commit();
                break;
            case 3:
                fragment_question quesfrag = new fragment_question();
                ft.replace(R.id.fragment_questions, quesfrag).commit();
                break;
            case 4:
                fragment_challenge chalfrag = new fragment_challenge();
                ft.replace(R.id.fragment_questions, chalfrag).commit();
                break;
            case 5:
                fragment_vote votefrag = new fragment_vote();
                ft.replace(R.id.fragment_questions, votefrag).commit();
                break;

        }
    }

}
