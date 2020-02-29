package com.dnd.InitiativeTracker.model.dao;

import com.dnd.InitiativeTracker.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
}
