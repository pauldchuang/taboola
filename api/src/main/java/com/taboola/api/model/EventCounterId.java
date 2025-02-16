package com.taboola.api.model;

import java.io.Serializable;
import java.util.Objects;

public class EventCounterId implements Serializable {
    private String timeBucket;
    private Integer eventId;

    public EventCounterId() {
    }

    public EventCounterId(String timeBucket, Integer eventId) {
        this.timeBucket = timeBucket;
        this.eventId = eventId;
    }

    // Getters and Setters
    public String getTimeBucket() {
        return timeBucket;
    }

    public void setTimeBucket(String timeBucket) {
        this.timeBucket = timeBucket;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventCounterId that = (EventCounterId) o;
        return Objects.equals(timeBucket, that.timeBucket) &&
                Objects.equals(eventId, that.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeBucket, eventId);
    }
}
