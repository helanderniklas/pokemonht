package com.example.harkkatyo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    private PokemonListAdapter adapter;
    TextView  pkmonName, pkmonAttack, pkmonDefense, pkmonLife, pkmonType, pkmonExperience;
    ImageView pkmonImg ;

    public PokemonViewHolder (@NonNull View itemView){
        super(itemView);
        pkmonName = itemView.findViewById(R.id.text_list_pkmon_name_single);
        pkmonType = itemView.findViewById(R.id.pkmon_type);
        pkmonAttack = itemView.findViewById(R.id.text_list_pkmon_attack_single);
        pkmonDefense = itemView.findViewById(R.id.text_list_pkmon_defence_single);
        pkmonExperience = itemView.findViewById(R.id.text_list_pkmon_experience_single);
        pkmonLife = itemView.findViewById(R.id.text_list_pkmon_life_single);
        pkmonImg = itemView.findViewById(R.id.pokemon_image);
    }
}
