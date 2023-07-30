package com.example.harkkatyo;

import java.util.ArrayList;

public class Storage {

    static ArrayList<Pokemon> pokemons = new ArrayList<>();
    static ArrayList<State> states = new ArrayList<State>();
    private static Storage storage = null;

    public static Storage getInstance(){
        if(storage == null) {
            storage = new Storage();
        }
        return storage;

    }

    public static void addPokemon(String name, String type, int attackPoints, int defensePoints, int lifePoints, int maxLifePoints,  int experiencePoints){
        pokemons.add(new Pokemon(name, type, attackPoints, defensePoints, lifePoints, maxLifePoints, experiencePoints, 0));
    }

    public static void updateState(Pokemon pokemon){

    }

    public static ArrayList<State> getState(){ return states;}

    public static ArrayList<Pokemon> getPokemon(){
        return pokemons;
    }

    public static void listPokemons(){
        for (Pokemon pokemon : pokemons){

        }
    }
}
