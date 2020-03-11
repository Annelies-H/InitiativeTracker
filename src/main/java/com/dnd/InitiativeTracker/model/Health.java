package com.dnd.InitiativeTracker.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Objects;

@Embeddable
public class Health {
    @Transient
    private static final int MIN_HP = 0;
    @Column(name="max_hp", nullable=false)
    private int maxHP;
    @Transient
    private int currentHP;

//constructors
    public Health() {
    }

    public Health(int maxHP) {
        this.maxHP = Math.max(maxHP, MIN_HP);
        currentHP = this.maxHP;
    }

//methods
    /**
     * Adjust the currentHP by a given amount.
     * Where the new currentHP cannot be higher than the maximum HP or lower than 0;
     * @param hpChange value by which the HP is changed
     */
    public void adjustHP(int hpChange) {
        currentHP = Math.min(maxHP, Math.max(0, currentHP + hpChange));
    }

    /**
     * Reset the currentHP to the creatures maximum HP
     */
    public void resetHP() {
        currentHP = maxHP;
    }

//comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Health health = (Health) o;
        return maxHP == health.maxHP &&
                currentHP == health.currentHP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxHP, currentHP);
    }

    //getters
    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

//setters
    public void setMaxHP(int maxHP) {
        this.maxHP = Math.max(maxHP, MIN_HP);
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

}
