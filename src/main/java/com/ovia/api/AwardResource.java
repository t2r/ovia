package com.ovia.api;

import com.ovia.model.award.Awards;
import com.ovia.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/awards")
public class AwardResource {
    @Autowired
    AwardService awardService;

    /**
     *
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    private Awards geAwards(@PathVariable("name") String name) {
        return awardService.getAwards(name);
    }
}
