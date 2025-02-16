CREATE TABLE IF NOT EXISTS event_counter (
    time_bucket VARCHAR(20),
    event_id INT,
    count INT,
    PRIMARY KEY (time_bucket, event_id)
);