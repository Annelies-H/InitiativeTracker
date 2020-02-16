package model;

import java.util.ArrayList;
import java.util.List;
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

//Getters
    public int getNrOfSides() {
        return nrOfSides;
    }


//Setters
    public void setNrOfSides(int nrOfSides) {
        this.nrOfSides = nrOfSides;
    }
}
