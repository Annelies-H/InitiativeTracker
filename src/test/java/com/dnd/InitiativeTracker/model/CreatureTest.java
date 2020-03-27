package com.dnd.InitiativeTracker.model;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreatureTest {

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
