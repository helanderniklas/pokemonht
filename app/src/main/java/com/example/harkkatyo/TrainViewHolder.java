package com.example.harkkatyo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrainViewHolder extends RecyclerView.ViewHolder {

    private TrainListAdapter adapter;
    RadioButton selectedPkmons;
    RadioGroup trainOptions;


    public TrainViewHolder(@NonNull View itemView, TrainListAdapter adapter) {
        super(itemView);
        this.adapter = adapter;
        trainOptions = itemView.findViewById(R.id.trainOptions);
        trainOptions.removeAllViews();

        int position = getAdapterPosition();
        Pokemon pokemon = adapter.getPokemonAt(position);

        for (int i = 0; i < adapter.getTrainOptions().size(); i++) {
            RadioButton radioButton = new RadioButton(itemView.getContext());
            radioButton.setId(i);
            radioButton.setText(adapter.getTrainOptions().get(i));
            trainOptions.addView(radioButton);
        }


        trainOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = getAdapterPosition();
                Pokemon pokemon = adapter.getPokemonAt(position);
                switch (checkedId) {
                    case R.id.selectedToTrain:
                        pokemon.setState(1);
                        break;
                }
                pokemon.setSelected(true);
            }
        });
    }
}
