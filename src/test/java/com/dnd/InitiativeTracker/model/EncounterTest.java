package com.dnd.InitiativeTracker.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    //Should pass unless the creature comparator was changed
    public void rearrangeCreaturesTest() {
        Stats stats = mock(Stats.class);
        Health health = mock(Health.class);

        Creature c1 = new Creature();
        c1.setName("Piet");
        c1.setCreatureID(1);
        c1.setHealth(health);
        c1.setStats(stats);
        c1.setInitiative(13);

        Creature c2 = new Creature();
        c2.setName("The Destroyer");
        c2.setCreatureID(14);
        c2.setHealth(health);
        c2.setStats(stats);
        c2.setInitiative(23);

        Creature c3 = new Creature();
        c3.setName("Fluffy");
        c3.setCreatureID(0);
        c3.setHealth(health);
        c3.setStats(stats);
        c3.setInitiative(22);

        Encounter actual = new Encounter();
        actual.addCreature(c1);
        actual.addCreature(c2);
        actual.addCreature(c3);
        actual.rearrange();

        List<Creature> expected = new ArrayList<>();
        expected.add(c2);
        expected.add(c3);
        expected.add(c1);

        assertEquals(expected, actual.getCreatures());
    }

}
