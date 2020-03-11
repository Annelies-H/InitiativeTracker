package com.dnd.InitiativeTracker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Die {
    private int nrOfSides;
    private Random generator;

//Constructors
    public Die(int nrOfSides) {
        this.generator = new Random();
        this.nrOfSides = nrOfSides;
    }

//Methods
    public Integer roll() {
        return generator.nextInt(nrOfSides) + 1;
    }

    public List<Integer> roll(int nrOfRolls) {
        List<Integer> result = new ArrayList<>(nrOfRolls);
        for (int i = 0; i < nrOfRolls; i++) {
            result.add(roll());
        }
        return result;
    }

    public String toString() {
        return "D" + nrOfSides;
    }


//Comparison


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Die die = (Die) o;
        return nrOfSides == die.nrOfSides &&
                Objects.equals(generator, die.generator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrOfSides, generator);
    }

    //Getters
    public int getNrOfSides() {
        return nrOfSides;
    }


//Setters
    public void setNrOfSides(int nrOfSides) {
        this.nrOfSides = nrOfSides;
    }
}
