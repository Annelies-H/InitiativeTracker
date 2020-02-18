package model;

public class Stats {

    private int maxHP;
    private int armorClass;
    private int dexMod;

//Constructors
    public Stats() {
    }

//Getters
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
