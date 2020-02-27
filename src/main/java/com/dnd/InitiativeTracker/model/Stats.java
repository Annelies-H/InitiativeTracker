package com.dnd.InitiativeTracker.model;

public class Stats {

    private String type;
    private int armorClass;
    private int dexMod;

//Constructors
    public Stats() {
        this("", 0,  0);
    }

    public Stats(String type, int armorClass, int dexMod) {
        this.type = type;
        this.armorClass = armorClass;
        this.dexMod = dexMod;
    }

//Methods
    public String toString() {
        return type;
    }

//Getters
    public String getType() {
        return type;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getDexMod() {
        return dexMod;
    }


//Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = Math.max(0, armorClass);
    }

    public void setDexMod(int dexMod) {
        this.dexMod = dexMod;
    }
}
