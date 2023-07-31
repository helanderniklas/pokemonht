package com.example.harkkatyo;

import android.content.Intent;
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
        FightListAdapter adapter = new FightListAdapter(this, Storage.getPokemonFight());
        recyclerView.setAdapter(adapter);



        startFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FightListAdapter adapter = (FightListAdapter) recyclerView.getAdapter();
                ArrayList<Pokemon> selectedToFight = adapter.selectedToFight();
                boolean exit = false;
                boolean PKM1Attack = true;
                boolean PKM2Attack = false;
                Pokemon PKM1 = selectedToFight.get(0);
                System.out.println(PKM1);
                Pokemon PKM2 = selectedToFight.get(1);
                System.out.println(PKM2);
                int PKM1AttackStrenght = 0;
                int PKM2AttackStrenght = 0;
                int PKM1Life = 0;
                int PKM2Life = 0;

                PKM1AttackStrenght = PKM1.getAttackPoints();
                PKM2AttackStrenght = PKM2.getAttackPoints();

                PKM1Life = PKM1.getLifePoints();
                PKM2Life = PKM2.getLifePoints();


                while(!exit){
                    System.out.println("hyökkäys alkaa");
                    if(PKM1Attack){
                        PKM1AttackStrenght = PKM1.getAttackPoints();
                        PKM2Life = PKM2.getLifePoints();
                        PKM2Life = PKM2Life - PKM1AttackStrenght;
                        PKM2.setLifePoints(PKM2Life);
                        PKM1Attack = false;
                        PKM2Attack = true;

                        dataArea.append(PKM1.getName() + " Hyökkää " + PKM1.getAttackPoints() + " iskupisteellä." + PKM2.getName() + " Menettää " + PKM1.getAttackPoints() + " elämänpistettä. Elämänpisteitä jäljellä " + PKM2Life + ". ");
                    }

                    else if(PKM2Attack){
                        PKM2AttackStrenght = PKM2.getAttackPoints();
                        PKM1Life = PKM1.getLifePoints();
                        PKM1Life = PKM1Life - PKM2AttackStrenght;
                        PKM2.setLifePoints(PKM2Life);
                        PKM2Attack = false;
                        PKM1Attack = true;
                        dataArea.setText(PKM2.getName() + " Hyökkää " + PKM2.getAttackPoints() + " iskupisteellä." + PKM1.getName() + " Menettää " + PKM1.getAttackPoints() + " elämänpistettä. Elämänpisteitä jäljellä " + PKM1Life + ".");

                    }

                   if(PKM1.getLifePoints() <= 0 || PKM2.getLifePoints() <= 0){
                        if (PKM1.getLifePoints() <= 0) {
                            //Storage.getPokemon().setState(3);
                            PKM1.setState(3);
                            dataArea.append(PKM1.getName() + " Kuolee.");
                        }
                        if (PKM2.getLifePoints() <= 0) {
                            PKM2.setState(3);
                            dataArea.append(PKM2.getName() + " Kuolee.");

                        }

                        exit = true;
                    }
                }
            }
        });
    }

    public void gotoHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
