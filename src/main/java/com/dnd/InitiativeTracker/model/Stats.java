package com.dnd.InitiativeTracker.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Stats {
    @Column(nullable=false)
    private int armorClass;
    @Column(name="max_hp", nullable=false)
    private int maxHP;
    @Column(nullable=false)
    private int dexMod;

//Constructors
    public Stats() {
    }

    public Stats(int armorClass, int dexMod, int maxHP) {
        this.armorClass = armorClass;
        this.dexMod = dexMod;
        this.maxHP = maxHP;
    }

//Getters

    public int getArmorClass() {
        return armorClass;
    }

    public int getMaxHP() {
        return maxHP;
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

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
}
