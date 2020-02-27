package com.dnd.InitiativeTracker.model;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User> {
    private String username;
    private String email;
    private String password;
    private List<Encounter> encounters;

//Constructors
    public User(String username) {
        this.username = username;
        encounters = new ArrayList<>();
    }

//Methods
    /**
     * Add a specific encounter to the list if its not yet in the list
     * @param encounter encouter to add
     */
    public void addEncounter(Encounter encounter) {
        if (!encounters.contains(encounter)) {
            encounters.add(encounter);
        }
    }

    /**
     * Remove a specific encounter from the list
     * @param encounter encounter to be removed
     */
    public void removeEncounter(Encounter encounter) {
        encounters.remove(encounter);
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public int compareTo(User other) {
        return email.compareTo(other.email);
    }
}
