package com.ovia.dao;

import com.ovia.model.award.Award;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardDao extends CrudRepository<Award, Long> {}
