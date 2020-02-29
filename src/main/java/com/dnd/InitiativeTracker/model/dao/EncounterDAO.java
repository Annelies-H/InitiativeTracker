package com.dnd.InitiativeTracker.model.dao;

import com.dnd.InitiativeTracker.model.Encounter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterDAO extends CrudRepository<Encounter, Integer> {
}
