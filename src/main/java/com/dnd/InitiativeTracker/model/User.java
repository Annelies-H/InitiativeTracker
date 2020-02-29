package com.dnd.InitiativeTracker.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Comparable<User> {
    @Id
    @GeneratedValue
    private int userID;
    @Column(nullable=false)
    private String username;
    @Column(nullable=false, unique=true)
    private String email;
    @Column(nullable=false)
    private String password;
    @OneToMany(mappedBy="user")
    private List<Encounter> encounters;

//Constructors
    public User() {}

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
