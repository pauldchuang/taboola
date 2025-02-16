package com.taboola.api;

import java.time.Instant;
import java.util.Optional;

import com.taboola.api.model.EventCounter;
import com.taboola.api.service.EventCounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController()
@RequestMapping("/api")
public class Controller {
    @Value("${spring.datasource.url}")
    private String dbUrl;


    private final EventCounterService service;

    public Controller(EventCounterService service) {
        this.service = service;
    }

    @GetMapping("/{timeBucket}/{eventId}")
    public Optional<EventCounter> getEventCounter(@PathVariable String timeBucket, @PathVariable int eventId) {
        return service.getEventCounter(timeBucket, eventId);
    }

    @GetMapping("/test")
    public String test() {
        return "Connected to: " + dbUrl;
    }

    @GetMapping("/currentTime")
    public long time() {
        return Instant.now().toEpochMilli();
    }
}
