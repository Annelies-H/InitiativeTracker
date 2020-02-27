package com.dnd.InitiativeTracker.model;

public class Creature implements Comparable<Creature> {
    private int id;
    private int nextID = 1;
    private String name;
    private Health hp;
    private int initiative;
    private Stats stats;
    private String remarks;

//Constructor
    public Creature() {
        this(new Stats());
    }
    public Creature(Stats stats) {
        this(stats, 0, stats.getType(), new Health(), 0, "");
    }

    public Creature(Stats stats,  int id, String name, Health health, int initiative, String remarks) {
        this.id = (id != 0) ? id : nextID++;
        this.name = name;
        this.hp = health;
        this.initiative = initiative;
        this.stats = stats;
        this.remarks = remarks;
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

    public String getRemarks() {
        return remarks;
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

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHP(Health hp) {
        this.hp = hp;
    }
}
