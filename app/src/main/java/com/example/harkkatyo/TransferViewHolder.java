package com.example.harkkatyo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class TransferViewHolder extends RecyclerView.ViewHolder {

    private TransferListAdapter adapter;

    CheckBox selectedPkmons;

    public TransferViewHolder(@NonNull View itemView, TransferListAdapter adapter){
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
