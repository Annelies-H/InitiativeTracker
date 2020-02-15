package model;

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
    public int roll() {
        return generator.nextInt(nrOfSides) + 1;
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
