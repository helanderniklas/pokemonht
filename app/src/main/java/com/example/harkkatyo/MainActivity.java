package com.example.harkkatyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gotoadd = findViewById(R.id.addpkm);
        Button gotolist = findViewById(R.id.listpkm);
        Button gotomove = findViewById(R.id.movepkm);
        Button gotofight = findViewById(R.id.gotofight);
    }

    public void SwitchToAdd(View view){
        Intent intent = new Intent(this, AddPokemons.class);
        startActivity(intent);
    }

    public void SwitchToList(View view){
        Intent intent = new Intent(this, AddPokemons.class);
        startActivity(intent);
    }

    public void SwitchToMove(View view){
        Intent intent = new Intent(this, AddPokemons.class);
        startActivity(intent);
    }

    public void SwitchToFight(View view){
        Intent intent = new Intent(this, AddPokemons.class);
        startActivity(intent);
    }
}