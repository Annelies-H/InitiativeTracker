package com.dnd.InitiativeTracker.model.repository;

import com.dnd.InitiativeTracker.model.User;
import com.dnd.InitiativeTracker.model.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRep;

    /*
    Twee manieren om findByUsername te testen, niet vergeten properties goed te zetten voor virtuele db
    #spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    */

    @Test
    public void whenFindByName_thenReturnUser() {
        User alex = new User("alex");
        alex.setEmail("ales@hotmail.com");
        alex.setPassword("ingewikkeldwachtwoord");
        entityManager.persist(alex);
        entityManager.flush();
        Optional<User> fromDB = userRep.findByUsername(alex.getUsername());
        assertThat(fromDB.get().getUsername()).isEqualTo(alex.getUsername());
    }

    @Test
    void findByUsername() {
        User testUser = new User("Piet");
        testUser.setEmail("Piet@hotmail.com");
        testUser.setPassword("wachtwoord");
        userRep.save(testUser);
        Optional<User> gevonden = userRep.findByUsername("Piet");
        if (gevonden.isPresent()) {
            User test = gevonden.get();
            assertThat(test.getUsername()).isEqualTo(testUser.getUsername());
        }
    }
}
