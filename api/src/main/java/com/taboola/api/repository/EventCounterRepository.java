package com.taboola.api.repository;

import com.taboola.api.model.EventCounter;
import com.taboola.api.model.EventCounterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventCounterRepository extends JpaRepository<EventCounter, EventCounterId> {
    List<EventCounter> findByTimeBucket(String timeBucket);
    Optional<EventCounter> findByTimeBucketAndEventId(String timeBucket, int eventId);
}
