package com.ovia.core;

import com.ovia.model.award.Award;
import com.ovia.model.event.EventType;
import com.ovia.model.mood.MoodStatus;
import com.ovia.service.AwardService;
import com.ovia.service.MoodStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BusinessRuleEngine {

    @Autowired
    AwardService awardService;

    @Autowired
    MoodStatusService moodStatusService;

    public BusinessRuleEngine() {}

    /**
     *
     * @param userName
     * @param eventType
     * @param eventDate
     * @return
     */
    public Award determineAward(String userName, EventType eventType, LocalDate eventDate) {
        Award award = null;
        if(eventType == EventType.BIRTH) {
            award = new Award(userName, EventType.BIRTH.name());
            award =  awardService.addAward(award);
        } else if(eventType == EventType.MOOD) {
            if(moodAwardAlgo(userName, eventDate)) {
                award = new Award(userName, EventType.MOOD.name());
                award = awardService.addAward(award);
            }
        }
        return award;
    }

    /**
     *
     * @param userName
     * @param eventDate
     * @return
     */
    private boolean moodAwardAlgo(String userName, LocalDate eventDate) {
        boolean earnAward = false;
        MoodStatus moodStatus = moodStatusService.getMoodStatus(userName);

        // Do we have a record in table for user, if not then create one
        if(moodStatus == null) {
           moodStatus = new MoodStatus(userName, 1, eventDate);
        } else {
            LocalDate latestMoodDate = moodStatus.getDate();

            // Did the user already log event today, if so exit
            if(eventDate.isEqual(latestMoodDate)) {
                return false;
            }

            // Did the user log yesterday, if not then level back to one
            if (!latestMoodDate.equals(eventDate.minusDays(1))) {
                moodStatus.setLevel(1);
                moodStatus.setDate(eventDate);
            } else {
                // Let's increment level
                moodStatus.setLevel(moodStatus.getLevel() + 1);
                moodStatus.setDate(eventDate);

                // Did user reach maxLevel, if so reset and trigger award
                if (moodStatus.getLevel() == 5) {
                    moodStatus.setLevel(0);
                    earnAward = true;
                }
            }
        }
        moodStatusService.saveMoodStatus(moodStatus);

        return earnAward;
    }
}
