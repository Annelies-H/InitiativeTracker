package com.dnd.InitiativeTracker.model.repository;

import com.dnd.InitiativeTracker.model.Creature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureRepository extends CrudRepository<Creature, Integer> {
}
