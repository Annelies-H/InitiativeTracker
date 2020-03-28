package com.dnd.InitiativeTracker.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class EncounterTest {

    @Test
    public void adjustAndResetHealthIntegrationTest() {
        Stats stats = mock(Stats.class);
        Creature c1 = new Creature(stats, 1, "goblin", 10, 13);
        c1.getHealth().adjustHP(-3);
        assertEquals(7, c1.getHealth().getCurrentHP());
        Creature c2 = new Creature(stats, 2, "dragon", 130, 9);
        c2.getHealth().adjustHP(-25);
        assertEquals(105, c2.getHealth().getCurrentHP());
        Encounter encounter = new Encounter();
        encounter.addCreature(c1);
        encounter.addCreature(c2);
        encounter.resetHP();
        assertEquals(10, encounter.getCreatures().get(0).getHealth().getCurrentHP());
        assertEquals(130, encounter.getCreatures().get(1).getHealth().getCurrentHP());
    }

}
