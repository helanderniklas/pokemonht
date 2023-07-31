package com.example.harkkatyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class TransferListAdapter extends RecyclerView.Adapter<TransferViewHolder> {

    private Context context;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Pokemon> filteredPokemons;
    private TransferListAdapter adapter;

    public TransferListAdapter(Context context, ArrayList<Pokemon> pokemons) {
        this.context = context;
        this.pokemons = pokemons;
        this.filteredPokemons = new ArrayList<>(pokemons);
    }

    @NonNull
    @Override
    public TransferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.transfer_list, parent, false);
        adapter = this;
        return new TransferViewHolder(itemView, adapter);    }

    @Override
    public void onBindViewHolder(@NonNull TransferViewHolder holder, int position) {
        holder.selectedPkmons.setText(filteredPokemons.get(position).getName() + " " + filteredPokemons.get(position).getType());
        holder.selectedPkmons.setClickable(filteredPokemons.get(position).getState() != 3);
    }

    @Override
    public int getItemCount() {
        return filteredPokemons.size();
    }

    public void updateList(ArrayList<Pokemon> updatedPokemons) {
        this.pokemons = updatedPokemons;
        getByState(0);
        notifyDataSetChanged();
    }

    public void getByState(int state) {
        filteredPokemons.clear();
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getState() == state) {
                filteredPokemons.add(pokemon);
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
            return filteredPokemons.get(position);
    }
}
