package com.dnd.InitiativeTracker.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Stats {
    @Column(nullable=false)
    private int armorClass;
    @Column(nullable=false)
    private int dexMod;

//Constructors
    public Stats() {
    }

    public Stats(int armorClass, int dexMod, int maxHP) {
        this.armorClass = armorClass;
        this.dexMod = dexMod;
    }

//Getters

    public int getArmorClass() {
        return armorClass;
    }

    public int getDexMod() {
        return dexMod;
    }

    //Setters


    public void setArmorClass(int armorClass) {
        this.armorClass = Math.max(0, armorClass);
    }

    public void setDexMod(int dexMod) {
        this.dexMod = dexMod;
    }

}
