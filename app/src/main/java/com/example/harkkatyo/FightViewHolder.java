package com.example.harkkatyo;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FightViewHolder extends RecyclerView.ViewHolder {

    private FightListAdapter adapter;
    CheckBox selectedPkmons;

    public FightViewHolder(@NonNull View itemView, FightListAdapter adapter) {
        super(itemView);
        this.adapter = adapter;
        selectedPkmons = itemView.findViewById(R.id.selectPokemon);

        selectedPkmons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                Pokemon pokemon = adapter.getPokemonAt(position);
                pokemon.setSelected(selectedPkmons.isChecked());
            }
        });
    }
}
