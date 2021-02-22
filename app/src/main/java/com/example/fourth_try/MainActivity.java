package com.example.fourth_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fourth_try.controller.card_list;
import com.example.fourth_try.controller.deck_list;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_play = (Button) findViewById(R.id.button_play);
        Button button_decks = (Button) findViewById(R.id.button_decks);
        Button button_cards = (Button) findViewById(R.id.button_cards);

        button_decks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDecks();
            }
        });

        button_cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCards();
            }
        });
    }

    public void openDecks(){
        Intent openDecks = new Intent(this, deck_list.class);
        startActivity(openDecks);
    }
    public void openCards(){
        Intent openCards = new Intent(this, card_list.class);
        startActivity(openCards);
    }
}