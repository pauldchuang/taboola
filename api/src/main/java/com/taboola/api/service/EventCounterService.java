package com.taboola.api.service;

import com.taboola.api.model.EventCounter;
import com.taboola.api.model.EventCounterId;
import com.taboola.api.repository.EventCounterRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EventCounterService {
    private final EventCounterRepository eventCounterRepository;

    public EventCounterService(EventCounterRepository repository) {
        this.eventCounterRepository = repository;
    }

    public Optional<EventCounter> getEventCounter(String timeBucket, int eventId) {
        return eventCounterRepository.findById(new EventCounterId(timeBucket, eventId));
    }
    
    public Map<Integer, Integer> getCountersByTimeBucket(String timeBucket) {
        List<EventCounter> counters = eventCounterRepository.findByTimeBucket(timeBucket);

        Map<Integer, Integer> eventCounts = new HashMap<>();
        for (EventCounter counter : counters) {
            eventCounts.put(counter.getEventId(), counter.getCount());
        }

        return eventCounts;
    }
    
    public long getCounterByTimeBucketAndEventId(String timeBucket, int eventId) {
        Optional<EventCounter> counter = eventCounterRepository.findByTimeBucketAndEventId(timeBucket, eventId);
        return counter.map(EventCounter::getCount).orElse(0);
    }
}