package com.example.fourth_try.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fourth_try.R;
import com.example.fourth_try.model.myDbAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class card_list extends AppCompatActivity {
    public myDbAdapter myDbAd = new myDbAdapter(this);


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_list);

        Button addQuestion = (Button) findViewById(R.id.button_add_card);
        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdd();
            }
        });

        RecyclerView recycler = findViewById(R.id.list_cards);
        CardAdapter cardAdapter;
        RecyclerView.LayoutManager layoutManager;
        List<Card> cardList = new ArrayList<>(myDbAd.getData());

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        cardAdapter = new CardAdapter(this, cardList, recycler);
        recycler.setAdapter(cardAdapter);








        //TODO Add Spinner Activity to change shown kinds of cards


    }


    public void openAdd() {
        Intent openAdd = new Intent(this, card_add.class);
        startActivity(openAdd);
    }

    /**
     * Confirmation to delete an item
     * TODO Implement a button next to an item to delete it
     */
    public void popupConfirmation(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Delete the Item");
        builder.setMessage("Do you really want to delete this Item?");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
