package com.dnd.InitiativeTracker.model.dao;

import com.dnd.InitiativeTracker.model.Creature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureDAO extends CrudRepository<Creature, Integer> {
}
