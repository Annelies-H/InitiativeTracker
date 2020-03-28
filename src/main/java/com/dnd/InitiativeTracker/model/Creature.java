package com.dnd.InitiativeTracker.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Creature implements Comparable<Creature> {
    @Id
    @GeneratedValue
    @Column(name="creature_id", nullable=false, unique=true)
    private int creatureID =0;
    @Column(name="creature_name", nullable=false)
    private String name;
    @Embedded
    private Health health;
    @Transient
    private int initiative;
    @Embedded
    @Column(nullable=false)
    private Stats stats;

//Constructor
    public Creature() { }

    public Creature(Stats stats, int creatureID, String name, int maxHP, int initiative) {
        this.creatureID = creatureID;
        this.name = name;
        this.health = new Health(maxHP);
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
    public String toString() {
        return name;
    }

//Comparison
    @Override
    public int compareTo(Creature otherCreature) {
        return otherCreature.initiative - initiative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return creatureID == creature.creatureID &&
                initiative == creature.initiative &&
                name.equals(creature.name) &&
                health.equals(creature.health) &&
                stats.equals(creature.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creatureID, name, health, initiative, stats);
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

    public int getCreatureID() {
        return creatureID;
    }

    public Health getHealth() {
        return health;
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

    public void setCreatureID(int id) {
        this.creatureID = id;
    }

    public void setHealth(Health health) {
        this.health = health;
    }
}
