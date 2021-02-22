package com.example.fourth_try.controller;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fourth_try.R;

public class deck_add extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_deck_name);

        final EditText name = (EditText) findViewById(R.id.editText_deckname);
        Button button_confirm = (Button) findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (TextUtils.isEmpty(name.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Proceed...", Toast.LENGTH_SHORT).show();
                    addQuestionToDeck();
                }

            }
        });
    }

    public void addQuestionToDeck(){
        Intent openAddQ = new Intent(this, deck_add_question.class);
        startActivity(openAddQ);
    }
}
