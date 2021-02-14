package com.ovia.service;

import com.ovia.dao.MoodStatusDao;
import com.ovia.model.mood.MoodStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MoodStatusService {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Autowired
    MoodStatusDao moodStatusDao;

    /**
     *
     * @param userName
     * @return
     */
    public MoodStatus getMoodStatus(String userName) {
        return moodStatusDao.findById(userName).orElse(null);
    }

    /**
     *
     * @param moodStatus
     * @return
     */
    public MoodStatus saveMoodStatus(MoodStatus moodStatus) {
        return moodStatusDao.save(moodStatus);
    }
}
