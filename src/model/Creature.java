package model;

public class Creature {
    private int id;
    private static int nextID = 1000000;
    private String name;
    private int currentHP;
    private int initiative;
    private Stats stats;
    private String remarks;

//Constructor
    public Creature() {
        id = nextID++;
        stats = new Stats();
        name = "";
        remarks = "";
    }

//Methods

    /**
     * Set a new random intitative by rolling a D20 and adding the dexterity modifier.
     * Initiative cannot negative.
     */
    public void rollInitiative() {
        Die d20 = new Die(20);
        initiative = Math.max(0, d20.roll() + stats.getDexMod());
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


//Getters
    public int getId() {
        return id;
    }

    public static int getNextID() {
        return nextID;
    }

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

    public int getMaxHP() {
        return stats.getMaxHP();
    }

    public int getDexMod() {
        return stats.getDexMod();
    }

    public int getArmourClass() {
        return stats.getArmorClass();
    }

    public String getRemarks() {
        return remarks;
    }


//Setters
    public void setId(int id) {
        this.id = id;
    }

    public static void setNextID(int nextID) {
        Creature.nextID = nextID;
    }

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
