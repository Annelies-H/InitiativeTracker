package com.dnd.InitiativeTracker.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Health {
    @Column(nullable=false)
    private int maxHP;
    @Transient
    private int currentHP;

//Constructors
    public Health(int maxHP) {
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public Health() {
        this(0);
    }

//Methods

    /**
     * Reset the currentHP to the creatures maximum HP
     */
    public void resetHP() {
        currentHP = maxHP;
    }

    /**
     * Adjust the currentHP by a given amount.
     * Where the new currentHP cannot be higher than the maximum HP or lower than 0;
     * @param hpChange value by which the HP is changed
     */
    public void adjustHP(int hpChange) {
        currentHP = Math.min(maxHP, Math.max(0, currentHP + hpChange));
    }

    public String toString(){
        return currentHP + "/" + maxHP;
    }

//Getters
    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

//Setters
public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
}
