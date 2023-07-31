package com.example.harkkatyo;

import java.util.UUID;

public class Pokemon {
    private String name;

    private String type;
    private int attackPoints;
    private int defensePoints;
    private int lifePoints;
    private int maxLifePoints;
    private int experiencePoints;

    private String uuid;

    private int state;
    private boolean isSelected;

    public Pokemon(String name, String type, int attackPoints, int defensePoints, int lifePoints, int maxLifePoints,  int experiencePoints, int state){
        this.name = name;
        this.type = type;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.lifePoints = lifePoints;
        this.maxLifePoints = maxLifePoints;
        this.experiencePoints = experiencePoints;
        this.state = state;
        this.uuid = UUID.randomUUID().toString();
        this.isSelected = false;

    }

    public String getName(){ return name; }
    public String getType(){ return type; }
    public int getAttackPoints(){ return attackPoints; }

    public void setAttackPoints(int attack){ this.attackPoints = attack;}
    public int getDefensePoints(){ return defensePoints; }
    public int getLifePoints(){ return lifePoints; }

    public void setLifePoints(int life){ this.lifePoints = life;}

    public int getMaxLifePoints(){ return maxLifePoints; }
    public int getExperiencePoints(){ return experiencePoints; }

    public int getState(){ return state;}

    public void setState(int newState){
        this.state = newState;
    }

    public String getUUID(){
        return uuid;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}

