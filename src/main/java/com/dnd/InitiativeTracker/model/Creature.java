package com.dnd.InitiativeTracker.model;

import javax.persistence.*;

@Entity
public class Creature implements Comparable<Creature> {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private Health hp;
    @Transient
    private int initiative;
    @Column(nullable=false)
    private Stats stats;

//Constructor
    public Creature() {
        this(new Stats(), new Health());
    }
    public Creature(Stats stats, Health hp) {
        this(stats, 0, stats.getType(), hp, 0);
    }

    public Creature(Stats stats,  int id, String name, Health health, int initiative) {
        this.id = id;
        this.name = name;
        this.hp = health;
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

    public Health getHP() {
        return hp;
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

    public void setHP(Health hp) {
        this.hp = hp;
    }
}
