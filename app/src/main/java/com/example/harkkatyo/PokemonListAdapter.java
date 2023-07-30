package com.example.harkkatyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private Context context;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public PokemonListAdapter(Context context, ArrayList<Pokemon> pokemons){
        this.context = context;
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new PokemonViewHolder(LayoutInflater.from(context).inflate(R.layout.listpkmon, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        holder.pkmonName.setText(pokemons.get(position).getName());
        holder.pkmonAttack.setText("Hyökkäys: " + String.valueOf(pokemons.get(position).getAttackPoints()));
        holder.pkmonDefense.setText("Puolustus: " + String.valueOf(pokemons.get(position).getDefensePoints()));
        holder.pkmonLife.setText("Elämät: " + String.valueOf(pokemons.get(position).getLifePoints()));
        holder.pkmonExperience.setText("Kokemus: " + String.valueOf(pokemons.get(position).getExperiencePoints()));
        holder.pkmonType.setText("Klaani: " + pokemons.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}
