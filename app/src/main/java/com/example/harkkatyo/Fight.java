package com.example.harkkatyo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fight extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);
        setContentView(R.layout.activity_fight);

        Button startFight = findViewById(R.id.startFight);
        TextView dataArea = findViewById(R.id.fightData);

        recyclerView = findViewById(R.id.fightList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FightListAdapter adapter = new FightListAdapter(this, Storage.getPokemon());
        recyclerView.setAdapter(adapter);



        startFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FightListAdapter adapter = (FightListAdapter) recyclerView.getAdapter();
                ArrayList<String> selectedUUIDs = adapter.getSelectedPokemonUUIDs();
                boolean exit = false;
                boolean PKM1Attack = true;
                boolean PKM2Attack = false;
                Pokemon PKM1 = Storage.get
                while(!exit){

                }
            }
        });
    }
}
