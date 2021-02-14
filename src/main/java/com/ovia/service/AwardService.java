package com.ovia.service;

import com.ovia.dao.AwardDao;
import com.ovia.model.award.Award;
import com.ovia.model.award.Awards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AwardService {

    @Autowired
    AwardDao awardDao;

    public Award addAward(Award award) {
        return awardDao.save(award);
    }

    /**
     *
     * @param userName
     * @return
     */
    public Awards getAwards(String userName) {
        Awards awards = new Awards();
        List<Award> list = new ArrayList<>();
        awardDao.findAll().forEach(award -> {
            if(award.getUserName().equals(userName)) {
                list.add(award);
            }
        });
        awards.setAwardList(list);
        return awards;
    }
}
