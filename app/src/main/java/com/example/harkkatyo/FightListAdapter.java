package com.example.harkkatyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FightListAdapter extends RecyclerView.Adapter<FightViewHolder> {

    private Context context;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Pokemon> filteredPokemons;    private FightListAdapter adapter;
    public FightListAdapter(Context context, ArrayList<Pokemon> pokemons){
        this.context = context;
        this. pokemons = pokemons;
        this.filteredPokemons = new ArrayList<>(pokemons);
    }


    @NonNull
    @Override
    public FightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemview = LayoutInflater.from(context).inflate(R.layout.transfer_list, parent, false);
       adapter = this;
       return new FightViewHolder(itemview, adapter);
    }

    @Override
    public void onBindViewHolder(@NonNull FightViewHolder holder, int position) {
    holder.selectedPkmons.setText(pokemons.get(position).getName() + " " + pokemons.get(position).getType());
    }

    @Override
    public int getItemCount() {
       return pokemons.size();
    }

    public Pokemon getPokemonAt(int position) {
        return filteredPokemons.get(position);
    }


    public ArrayList<Pokemon> selectedToFight() {
        ArrayList<Pokemon> selectedToFight = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getState() == 2) {
                selectedToFight.add(pokemon);
            }
        }
        return selectedToFight;
    }
}
