package com.example.fourth_try;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_play = (Button) findViewById(R.id.button_play);
        Button button_decks = (Button) findViewById(R.id.button_decks);
        Button button_cards = (Button) findViewById(R.id.button_cards);
    }
}