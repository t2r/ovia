package com.ovia.service;

import com.ovia.core.BusinessRuleEngine;
import com.ovia.dao.MoodEventDao;
import com.ovia.model.award.Award;
import com.ovia.model.event.EventType;
import com.ovia.model.event.MoodEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

@Service
public class MoodEventService {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Autowired
    MoodEventDao moodEventDao;

    @Autowired
    BusinessRuleEngine businessRuleEngine;


    /**
     *
     * @param id
     * @return
     */
    public MoodEvent getMoodEvent(Long id) {
        return moodEventDao.findById(id).get();
    }

    /**
     *
     * @param moodEvent
     * @return
     */
    public Award addEvent(MoodEvent moodEvent) {
        moodEventDao.save(moodEvent);

        // TODO:  This trigger an event rather than hold the api response
        return businessRuleEngine.determineAward(moodEvent.getUserName(), EventType.MOOD, moodEvent.getDateTime().toLocalDate());
    }
}
