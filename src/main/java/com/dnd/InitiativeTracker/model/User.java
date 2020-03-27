package com.dnd.InitiativeTracker.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id", nullable=false, unique=true)
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


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID &&
                username.equals(user.username) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                encounters.equals(user.encounters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, username, email, password, encounters);
    }
}
