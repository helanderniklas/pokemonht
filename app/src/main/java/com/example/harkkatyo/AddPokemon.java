package com.example.harkkatyo;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;


import androidx.appcompat.app.AppCompatActivity;

public class AddPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpkmon);

        Button submit = findViewById(R.id.confrimAddPkmon);
        RadioGroup type = findViewById(R.id.pkmonType);
        TextView name = findViewById(R.id.pkmonName);
        int selectedType = type.getCheckedRadioButtonId();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namePKM = name.getText().toString();
                int selectedRadioButtonId = type.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String typePKM = selectedRadioButton.getText().toString();

                int attackPoints = 0, defensePoints = 0, lifePoints = 0, maxLifePoints = 0, experiencePoints = 0;

                switch(typePKM){
                    case "oranssi":
                        attackPoints = 5;
                        defensePoints = 4;
                        maxLifePoints = 20;
                        lifePoints = 20;
                        break;
                    case "keltainen":
                        attackPoints = 6;
                        defensePoints = 3;
                        maxLifePoints = 19;
                        lifePoints = 19;
                        break;
                    case "sininen":
                        attackPoints = 7;
                        defensePoints = 2;
                        maxLifePoints = 18;
                        lifePoints = 18;
                        break;
                    case "vihreä":
                        attackPoints = 8;
                        defensePoints = 1;
                        maxLifePoints = 17;
                        lifePoints = 17;
                        break;
                    case "punainen":
                        attackPoints = 9;
                        defensePoints = 0;
                        maxLifePoints = 16;
                        lifePoints = 16;
                        break;
                }

                if(name == null || typePKM == null){

                }
                else{
                    Storage.addPokemon(namePKM, typePKM, attackPoints, defensePoints, lifePoints, maxLifePoints, experiencePoints);
                    Intent intent = new Intent(AddPokemon.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
