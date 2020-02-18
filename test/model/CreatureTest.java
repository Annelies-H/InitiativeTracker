package model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CreatureTest {

    @Test
    public void changeHP() {
        Creature creature = new Creature();
        creature.getStats().setMaxHP(20);
        assertEquals("currentHP should initialise at 0",0, creature.getCurrentHP());
        creature.resetHP();
        assertEquals("reset should return currentHP to its maximum", 20,creature.getCurrentHP());
        creature.adjustHP(-5);
        assertEquals("lowering HP", 15, creature.getCurrentHP());
        creature.adjustHP(2);
        assertEquals("adding HP", 17, creature.getCurrentHP());
        creature.adjustHP(10);
        assertEquals("currentHP should not be higher than maxHP", 20, creature.getCurrentHP());
        creature.adjustHP(-100);
        assertEquals("currentHP should not fall below", 0, creature.getCurrentHP());
    }

    @Test
    public void compareTo() {
        Creature ten = new Creature("ten");
        ten.setInitiative(10);
        Creature fifteen = new Creature("fifteen");
        fifteen.setInitiative(15);
        Creature anotherTen = new Creature("anotherTen");
        anotherTen.setInitiative(10);
        Creature six = new Creature("six");
        six.setInitiative(6);
        Creature zero = new Creature("zero");
        Creature[] creatures = {ten, fifteen, anotherTen, six, zero};
        Arrays.sort(creatures);
        Creature[] expected = {zero, six, ten, anotherTen, fifteen};
        assertArrayEquals(expected, creatures);
    }


}
