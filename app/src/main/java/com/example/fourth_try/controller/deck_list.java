package com.example.fourth_try.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fourth_try.R;

public class deck_list extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.deck_list );

        Button add_deck = (Button) findViewById(R.id.button_add_deck);

        add_deck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addDeck();
            }
        });

    }


    public void addDeck(){
        Intent addDeck = new Intent(this, deck_add.class);
        startActivity(addDeck);
    }

}
