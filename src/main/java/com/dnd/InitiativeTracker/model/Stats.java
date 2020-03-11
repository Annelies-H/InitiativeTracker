package com.dnd.InitiativeTracker.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.util.Objects;

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

//Methods


//Comparison

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return armorClass == stats.armorClass &&
                dexMod == stats.dexMod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(armorClass, dexMod);
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
