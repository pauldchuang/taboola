package com.taboola.api.service;

import com.taboola.api.model.EventCounter;
import com.taboola.api.model.EventCounterId;
import com.taboola.api.repository.EventCounterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventCounterService {
    private final EventCounterRepository repository;

    public EventCounterService(EventCounterRepository repository) {
        this.repository = repository;
    }

    public Optional<EventCounter> getEventCounter(String timeBucket, int eventId) {
        return repository.findById(new EventCounterId(timeBucket, eventId));
    }
}