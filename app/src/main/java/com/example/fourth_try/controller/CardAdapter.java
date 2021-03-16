package com.example.fourth_try.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fourth_try.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    Context context;
    List<Card> cardList;
    RecyclerView recycler;
    final View.OnClickListener onClickListener = new MyOnClickListener();

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textText;
        TextView textSips;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textText = itemView.findViewById(R.id.textText);
            textSips = itemView.findViewById(R.id.textSips);
        }
    }

    public CardAdapter(Context context, List<Card> cardList, RecyclerView recycler){
        this.context = context;
        this.cardList = cardList;
        this.recycler = recycler;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_card_list, viewGroup);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int i) {
        Card card = cardList.get(i);
        ViewHolder viewHolder = null;
        viewHolder.textText.setText(card.getText());
        viewHolder.textSips.setText(card.getSips());
        
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int itemPosition = recycler.getChildLayoutPosition(view);
            String item = cardList.get(itemPosition).getText();
            Toast.makeText(context, item, Toast.LENGTH_SHORT).show();
        }
    }
}
