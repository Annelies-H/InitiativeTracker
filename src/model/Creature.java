package model;

public class Creature implements Comparable<Creature> {
    private int id;
    private int nextID = 1;
    private String name;
    private int currentHP;
    private int initiative;
    private Stats stats;
    private String remarks;

//Constructor
    public Creature() {
        this(new Stats());
    }
    public Creature(Stats stats) {
        this(stats, 0, stats.getType(), stats.getMaxHP(), 0, "");
    }

    public Creature(Stats stats,  int id, String name, int currentHP, int initiative, String remarks) {
        this.id = (id != 0) ? id : nextID++;
        this.name = name;
        this.currentHP = currentHP;
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

    public int getCurrentHP() {
        return currentHP;
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

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = Math.max(0, currentHP);
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
}
