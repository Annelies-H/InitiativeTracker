package com.dnd.InitiativeTracker.model;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreatureTest {

    @Test
    public void changeHP() {
        Creature creature = new Creature();
        creature.getHP().setMaxHP(20);
        assertEquals(0, creature.getHP().getCurrentHP(), "currentHP should initialise at 0");
        creature.getHP().resetHP();
        assertEquals(20,creature.getHP().getCurrentHP(), "reset should return currentHP to its maximum");
        creature.getHP().adjustHP(-5);
        assertEquals(15, creature.getHP().getCurrentHP(), "lowering HP" );
        creature.getHP().adjustHP(2);
        assertEquals(17, creature.getHP().getCurrentHP(), "adding HP");
        creature.getHP().adjustHP(10);
        assertEquals( 20, creature.getHP().getCurrentHP(), "currentHP should not be higher than maxHP");
        creature.getHP().adjustHP(-100);
        assertEquals(0, creature.getHP().getCurrentHP(), "currentHP should not fall below");
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
