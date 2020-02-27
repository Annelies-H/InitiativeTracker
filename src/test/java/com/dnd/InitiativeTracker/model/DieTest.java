package com.dnd.InitiativeTracker.model;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DieTest {

    private static final int NR_OF_SIDES = 20;
    private static final Die DIE = new Die(NR_OF_SIDES);
    private static final int NR_OF_ROLLS = (int) Math.pow(10, 6);
    private static final int MIN = 1;
    private static final double MARGIN_OF_ERROR = 0.01;
    private static final int REPEATS = 10;

    @Test
    public void dieToString() {
        assertEquals("D6", (new Die(6)).toString());
        assertEquals("D12", (new Die(12)).toString());
        assertEquals("D20", (new Die(20)).toString());
        assertEquals("D358", (new Die(358)).toString());
    }

    @Test
    public void dieRollMinMax() {
        List<Integer> rolls = DIE.roll(NR_OF_ROLLS);
        assertTrue(Collections.min(rolls) >= MIN);
        assertTrue(Collections.max(rolls) <=NR_OF_SIDES);
    }

    @Test
    public void repeatDieRollMinMax() {
        for (int i = 0; i < REPEATS ; i++) {
            dieRollMinMax();
        }
    }

    @Test
    public void dieRollDistribution() {
        List<Integer> rolls = DIE.roll(NR_OF_ROLLS);
        Double expectedFrequencie = 1.0 / NR_OF_SIDES;

        for (int i = 0; i < NR_OF_SIDES; i++) {
            Double actual = Collections.frequency(rolls, i+1) / (NR_OF_ROLLS * 1.0);
            assertEquals(expectedFrequencie, actual, MARGIN_OF_ERROR);
        }
    }

    @Test
    public void repeatDieRollDistribution() {
        for (int i = 0; i < REPEATS ; i++) {
            dieRollDistribution();
        }
    }

}
