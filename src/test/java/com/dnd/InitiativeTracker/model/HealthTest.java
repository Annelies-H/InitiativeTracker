package com.dnd.InitiativeTracker.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthTest {

    @Test
    void initialiseHP() {
        Health negative = new Health(-3);
        assertEquals(0, negative.getMaxHP(), "maxHP cannot be lower then zero");
        Health health = new Health (20);
        assertEquals(20, health.getMaxHP(),"maxHP should be given value when positive");
        assertEquals(health.getMaxHP(), health.getCurrentHP(), "currentHP should equal max HP");
    }

    @Test
    void reduceHP() {
        Health health = new Health(20);
        health.adjustHP(-5);
        assertEquals(15, health.getCurrentHP(), "lowering HP" );
        health.adjustHP(-100);
        assertEquals(0, health.getCurrentHP(), "currentHP should not fall below zero");
    }

    @Test
    void addHP() {
        Health health = new Health(20);
        health.setCurrentHP(10);
        health.adjustHP(5);
        assertEquals(15, health.getCurrentHP(), "increading HP" );
        health.adjustHP(100);
        assertEquals(20, health.getCurrentHP(), "currentHP should not exceed maxHP");
    }

    @Test
    void resetHP() {
        Health health = new Health(20);
        health.setCurrentHP(10);
        health.resetHP();
        assertEquals(20, health.getCurrentHP(), "resetting hp");
    }

}