package com.ovia.service;

import com.ovia.core.BusinessRuleEngine;
import com.ovia.dao.BirthEventDao;
import com.ovia.model.award.Award;
import com.ovia.model.event.BirthEvent;
import com.ovia.model.event.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

@Service
public class BirthEventService {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Autowired
    BirthEventDao birthEventDao;

    @Autowired
    BusinessRuleEngine businessRuleEngine;

    /**
     *
     * @param id
     * @return
     */
    public BirthEvent getBirthEvent(Long id) {
        return birthEventDao.findById(id).get();
    }

    /**
     *
     * @param birthEvent
     * @return
     */
    public Award addEvent(BirthEvent birthEvent) {
        birthEventDao.save(birthEvent);

        // TODO:  This trigger an event rather than hold the api response
        return businessRuleEngine.determineAward(birthEvent.getUserName(), EventType.BIRTH, birthEvent.getDateTime().toLocalDate());
    }
}
