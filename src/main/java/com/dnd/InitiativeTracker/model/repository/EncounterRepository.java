package com.dnd.InitiativeTracker.model.repository;

import com.dnd.InitiativeTracker.model.Encounter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterRepository extends CrudRepository<Encounter, Integer> {
}
