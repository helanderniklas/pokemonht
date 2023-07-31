package com.example.harkkatyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainListAdapter extends RecyclerView.Adapter<TrainViewHolder> {

    private Context context;
    private TrainListAdapter adapter;

    private ArrayList<Pokemon> pokemons;

    private ArrayList<Pokemon> filteredPokemonTrain;

    public TrainListAdapter(Context context, ArrayList<Pokemon> pokemons){
        this.context = context;
        this.pokemons = pokemons;
        this.filteredPokemonTrain = new ArrayList<>(pokemons);
    }

    @NonNull
    @Override
    public TrainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.train_list, parent, false);
        adapter = this;
        return new TrainViewHolder(itemView, adapter);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainViewHolder holder, int position) {
        holder.selectedPkmons.setText(filteredPokemonTrain.get(position).getName() + ", kokemuspisteet: " + filteredPokemonTrain.get(position).getExperiencePoints());

    }

    @Override
    public int getItemCount() {
        return filteredPokemonTrain.size();
    }

    public void getByState(int state) {
        filteredPokemonTrain.clear();
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getState() == state) {
                filteredPokemonTrain.add(pokemon);
            }
        }
        notifyDataSetChanged();
    }

    public ArrayList<Pokemon> getSelectedPokemons() {
        ArrayList<Pokemon> selectedPokemons = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            if (pokemon.isSelected()) {
                selectedPokemons.add(pokemon);
            }
        }
        return selectedPokemons;
    }

    public Pokemon getPokemonAt(int position) {
        return filteredPokemonTrain.get(position);
    }
}
