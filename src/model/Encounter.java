package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Encounter implements Comparable<Encounter> {
    private int id;
    private String name;
    private List<Creature> creatures;

//Constructors
    public Encounter() {
        this("untitled");
    }

    public Encounter(String name) {
        this(name, 0);
    }

    public Encounter(String name, int id) {
        this.id = id;
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
        int id = creature.getId();
        boolean result = true;
        for (Creature member : creatures) {
            if (member.getId() == id) {
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
        return id - other.getId();
    }

//Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

//setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }
}
