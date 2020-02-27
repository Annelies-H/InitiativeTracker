package com.dnd.InitiativeTracker.model;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreatureTest {

    @Test
    public void changeHP() {
        Creature creature = new Creature();
        creature.getStats().setMaxHP(20);
        assertEquals(0, creature.getCurrentHP(), "currentHP should initialise at 0");
        creature.resetHP();
        assertEquals(20,creature.getCurrentHP(), "reset should return currentHP to its maximum");
        creature.adjustHP(-5);
        assertEquals(15, creature.getCurrentHP(), "lowering HP" );
        creature.adjustHP(2);
        assertEquals(17, creature.getCurrentHP(), "adding HP");
        creature.adjustHP(10);
        assertEquals( 20, creature.getCurrentHP(), "currentHP should not be higher than maxHP");
        creature.adjustHP(-100);
        assertEquals(0, creature.getCurrentHP(), "currentHP should not fall below");
    }

    @Test
    public void compareTo() {
        Creature ten = new Creature();
        ten.setInitiative(10);
        Creature fifteen = new Creature();
        fifteen.setInitiative(15);
        Creature anotherTen = new Creature();
        anotherTen.setInitiative(10);
        Creature six = new Creature();
        six.setInitiative(6);
        Creature zero = new Creature();
        Creature[] creatures = {ten, fifteen, anotherTen, six, zero};
        Arrays.sort(creatures);
        Creature[] expected = {zero, six, ten, anotherTen, fifteen};
        assertArrayEquals(expected, creatures);
    }


}
