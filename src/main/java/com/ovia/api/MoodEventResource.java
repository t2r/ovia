package com.ovia.api;

import com.ovia.model.event.MoodEvent;
import com.ovia.service.MoodEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events/mood")
public class MoodEventResource {
    @Autowired
    private MoodEventService moodEventService;

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public MoodEvent getBirthEvent(@PathVariable("id") Long id) {
        return moodEventService.getMoodEvent(id);
    }

    @PostMapping()
    public void addEvent(@RequestBody MoodEvent event) {
        moodEventService.addEvent(event);
    }
}
