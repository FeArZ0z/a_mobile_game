package com.example.fourth_try.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fourth_try.R;

public class card_list extends AppCompatActivity {
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
