package com.ovia.dao;

import com.ovia.model.event.BirthEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthEventDao extends CrudRepository<BirthEvent, Long> {}
