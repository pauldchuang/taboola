package com.taboola.api;

import java.time.Instant;
import java.util.Map;
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


    private final EventCounterService eventCounterService;

    public Controller(EventCounterService service) {
        this.eventCounterService = service;
    }

    @GetMapping("/currentTime")
    public long time() {
        return Instant.now().toEpochMilli();
    }

    @GetMapping("/counters/time/{timeBucket}")
    public Map<Integer, Integer> getCountersByTimeBucket(@PathVariable String timeBucket) {
        return eventCounterService.getCountersByTimeBucket(timeBucket);
    }

    @GetMapping("/counters/time/{timeBucket}/eventId/{eventId}")
    public long getCounterByTimeBucketAndEventId(@PathVariable String timeBucket, @PathVariable int eventId) {
        return eventCounterService.getCounterByTimeBucketAndEventId(timeBucket, eventId);
    }
}
