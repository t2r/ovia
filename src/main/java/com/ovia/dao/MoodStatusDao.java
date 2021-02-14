package com.ovia.dao;

import com.ovia.model.mood.MoodStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodStatusDao extends CrudRepository<MoodStatus, String> { }
