package com.dnd.InitiativeTracker.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Encounter implements Comparable<Encounter> {
    @Id
    @GeneratedValue
    @Column(name="encounter_id", nullable=false, unique=true)
    private int encounterID;
    @Column(name="encounter_name", nullable=false)
    private String name;
    @ManyToMany
    @JoinTable(
            name = "encounter_creature",
            joinColumns = { @JoinColumn(name = "encounter_id") },
            inverseJoinColumns = { @JoinColumn(name = "creature_id") }
    )
    private List<Creature> creatures;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

//Constructors
    public Encounter() {
        this("untitled");
    }

    public Encounter(String name) {
        this(name, 0);
    }

    public Encounter(String name, int encounterID) {
        this.encounterID = encounterID;
        this.name = name;
        creatures = new ArrayList<>();
    }

//Methods
    /**
     * Add a single creature to the encounter, but only if its not in the list yet
     * @param creature creature to add
     */
    public void addCreature(Creature creature) {
        if (doesNotContainCreature(creature)) {
            creatures.add(creature);
        }
    }

    /**
     * Helper method to addCreature. Check if a certain creature is already in the encounter or not
     * @param creature creature which presence is checked
     * @return true = creature not in the encounter, false = creature in the encounter
     */
    public boolean doesNotContainCreature(Creature creature) {
        int id = creature.getCreatureID();
        boolean result = true;
        for (Creature member : creatures) {
            if (member.getCreatureID() == id) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * reset the HP of all creatures in the encounter to their respective maximum
     */
    public void resetHP() {
        for (Creature creature : creatures) {
            creature.resetHP();
        }
    }

    /**
     * sort the order of the creatures in the encounter based on their initiative
     */
    public void rearrange() {
        Collections.sort(creatures);
    }

    /**
     * roll initiative for all the creatures in the encounter and then rearrange their order accordingly
     */
    public void rollInitiative() {
        for (Creature creature : creatures) {
            creature.rollInitiative();
        }
        rearrange();
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Encounter other) {
        return encounterID - other.getEncounterID();
    }

//Getters
    public int getEncounterID() {
        return encounterID;
    }

    public String getName() {
        return name;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

//setters
    public void setEncounterID(int id) {
        this.encounterID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }
}
