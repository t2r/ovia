package com.ovia.api;

import com.ovia.model.award.Award;
import com.ovia.model.event.BirthEvent;
import com.ovia.service.BirthEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events/birth")
public class BirthEventResource {
    @Autowired
    private BirthEventService birthEventService;

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public BirthEvent getBirthEvent(@PathVariable("id") Long id) {
        return birthEventService.getBirthEvent(id);
    }

    /**
     *
     * @param event
     * @return
     */
    @PostMapping()
    public Award addEvent(@RequestBody BirthEvent event) {
        return birthEventService.addEvent(event);
    }
}
