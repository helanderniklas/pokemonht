package com.example.harkkatyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Transfer extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle saveInstance) {

        super.onCreate(saveInstance);
        setContentView(R.layout.activity_transfer);

        recyclerView = findViewById(R.id.selectorRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TransferListAdapter adapter = new TransferListAdapter(this, Storage.getPokemon());
        recyclerView.setAdapter(adapter);
        adapter.getByState(0);

        Button doSubmit = findViewById(R.id.submitTransfer);
        Button gotoHome = findViewById(R.id.gotoHome);
        Button gotoTrain = findViewById(R.id.gotoTrain);
        Button gotoFigth = findViewById(R.id.gotoFigth);
        Button gotoDead = findViewById(R.id.gotoDead);

        gotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getByState(0);
                System.out.println("state on 0");
            }
        });

        gotoTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getByState(1);
            }
        });

        gotoFigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getByState(2);
            }
        });

        gotoDead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getByState(3);
            }
        });

        doSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gets selection where pkmons wants to be transferred
                RadioGroup type = findViewById(R.id.trainOptions);
                int selectedRadioButtonId = type.getCheckedRadioButtonId();
                RadioButton whereToSubmit = findViewById(selectedRadioButtonId);
                String where = whereToSubmit.getText().toString();

                //Gets selected pkmons
                CheckBox selectedPkmsToTransfer = findViewById(R.id.selectPokemon);
                ArrayList<Pokemon> selectedPokemons = adapter.getSelectedPokemons();
                System.out.println("selected " + + selectedPokemons.size());

                switch(where){
                    case"Kotiin":
                        for(Pokemon pokemon : selectedPokemons){
                            pokemon.setState(0);
                            pokemon.setSelected(false);
                        }
                        break;
                    case"Treenaamaan":
                        for(Pokemon pokemon : selectedPokemons){
                            pokemon.setState(1);
                            pokemon.setSelected(false);

                        }
                        break;
                    case"Taisteluareenalle":
                        for(Pokemon pokemon : selectedPokemons){
                            pokemon.setState(2);
                            pokemon.setSelected(false);

                        }
                        break;
                }

                //adapter.updateList(Storage.getPokemon());
                adapter.notifyDataSetChanged();
                selectedPokemons.clear();
            }
        });
    }

    public void goToMainScreen(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
