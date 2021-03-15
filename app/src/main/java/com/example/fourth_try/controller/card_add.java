package com.example.fourth_try.controller;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fourth_try.R;
import com.example.fourth_try.model.myDbAdapter;
import com.example.fourth_try.view.fragment_blank;
import com.example.fourth_try.view.fragment_caliente;
import com.example.fourth_try.view.fragment_challenge;
import com.example.fourth_try.view.fragment_normal;
import com.example.fourth_try.view.fragment_question;
import com.example.fourth_try.view.fragment_vote;

import java.util.ArrayList;

public class card_add extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //public enum KindOfCard{
    //    NOTHING, NORMAL, CALIENTE, QUESTION, CHALLENGE, VOTE;
    //}
    public int category = 0;
    public myDbAdapter myDbAd = new myDbAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card_new);

        //TODO add spinner activity to show different fragments for different kinds of cards
        Spinner dropdown = findViewById(R.id.spinner_add_choice);
        dropdown.setAdapter(new ArrayAdapter<KindOfCard>(this, android.R.layout.simple_spinner_dropdown_item, KindOfCard.values()));
        dropdown.setOnItemSelectedListener(this);

        Button savebtn = (Button) findViewById(R.id.button_save_question);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInput();

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int i, long id) {

        changeFragment(i);

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
                category = 0;
                break;
            case 1:
                fragment_normal normalfrag = new fragment_normal();
                ft.replace(R.id.fragment_questions, normalfrag).commit();
                category = 1;
                break;
            case 2:
                fragment_caliente calfrag = new fragment_caliente();
                ft.replace(R.id.fragment_questions, calfrag).commit();
                category = 2;
                break;
            case 3:
                fragment_question quesfrag = new fragment_question();
                ft.replace(R.id.fragment_questions, quesfrag).commit();
                category = 3;
                break;
            case 4:
                fragment_challenge chalfrag = new fragment_challenge();
                ft.replace(R.id.fragment_questions, chalfrag).commit();
                category = 4;
                break;
            case 5:
                fragment_vote votefrag = new fragment_vote();
                ft.replace(R.id.fragment_questions, votefrag).commit();
                category = 5;
                break;

        }
    }

    public void saveInput(){
        EditText text = (EditText) findViewById(R.id.InputText);
        String valueText = text.getText().toString();
        EditText sips = (EditText)findViewById(R.id.editTextNumber);
        String valueSips = sips.getText().toString();
        String cat = String.valueOf(category);
        Card card = new Card(valueText, valueSips, cat);
        myDbAd.insertData(card);
    }

}
