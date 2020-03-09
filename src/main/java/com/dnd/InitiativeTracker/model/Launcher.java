package com.dnd.InitiativeTracker.model;

public class Launcher {

    public static void main(String[] args) {

        Creature test = new Creature();
        test.getStats().setDexMod(-3);
        test.rollInitiative();
        System.out.println(test.getInitiative());
        test.rollInitiative();
        System.out.println(test.getInitiative());
        test.getHealth().adjustHP(10);
        System.out.println(test.getHealth().getCurrentHP());
    }
}
