package com.ovia.dao;

import com.ovia.model.event.MoodEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodEventDao extends CrudRepository<MoodEvent, Long> {}
