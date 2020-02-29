package com.dnd.InitiativeTracker.model;

import javax.persistence.*;

@Entity
public class Creature implements Comparable<Creature> {
    @Id
    @GeneratedValue
    @Column(nullable=false)
    private int id=0;
    @Column(nullable=false)
    private String name;
    @Transient
    private int currentHP;
    @Transient
    private int initiative;
    @Embedded
    @Column(nullable=false)
    private Stats stats;

//Constructor
    public Creature() { }

    public Creature(Stats stats,  int id, String name, int currentHP, int initiative) {
        this.id = id;
        this.name = name;
        this.currentHP = currentHP;
        this.initiative = initiative;
        this.stats = stats;
    }

//Methods

    /**
     * Set a new random intitative by rolling a D20 and adding the dexterity modifier.
     */
    public void rollInitiative() {
        Die d20 = new Die(20);
        initiative = d20.roll() + stats.getDexMod();
    }

    /**
     * Adjust the currentHP by a given amount.
     * Where the new currentHP cannot be higher than the maximum HP or lower than 0;
     * @param hpChange value by which the HP is changed
     */
    public void adjustHP(int hpChange) {
        currentHP = Math.min(stats.getMaxHP(), Math.max(0, currentHP + hpChange));
    }

    /**
     * Reset the currentHP to the creatures maximum HP
     */
    public void resetHP() {
        currentHP = stats.getMaxHP();
    }

    @Override
    public int compareTo(Creature otherCreature) {
        return initiative - otherCreature.initiative;
    }

    @Override
    public String toString() {
        return name;
    }


//Getters
    public String getName() {
        return name;
    }

    public int getInitiative() {
        return initiative;
    }

    public Stats getStats() {
        return stats;
    }

    public int getId() {
        return id;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setInitiative(int initiative) {
        this.initiative = Math.max(0, initiative);
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
}
