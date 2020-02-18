package model;

public class Stats {

    private String type;
    private int maxHP;
    private int armorClass;
    private int dexMod;

//Constructors
    public Stats() {
        type = "";

    }

    public Stats(String type, int maxHP, int armorClass, int dexMod, String remarks) {
        this.type = type;
        this.maxHP = maxHP;
        this.armorClass = armorClass;
        this.dexMod = dexMod;
    }

//Methods
    public String toString() {
        return type;
    }

//Getters
    public String getType() {
        return type;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getDexMod() {
        return dexMod;
    }


//Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = Math.max(0, maxHP);
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = Math.max(0, armorClass);
    }

    public void setDexMod(int dexMod) {
        this.dexMod = dexMod;
    }
}
