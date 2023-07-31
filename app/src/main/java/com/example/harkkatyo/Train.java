package com.example.harkkatyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Train extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle saveInstance){
        super.onCreate(saveInstance);
        setContentView(R.layout.activity_train);

        recyclerView = findViewById(R.id.trainingRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TrainListAdapter adapter = new TrainListAdapter(this, Storage.getPokemonTrain());
        recyclerView.setAdapter(adapter);
    }

    public void goMainPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
