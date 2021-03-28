package com.goyeneche.models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Meeting implements Comparable<Meeting>{

    private long id;
    private Person responsible;
    private LocalDateTime start;
    private LocalDateTime end;
    private Room room;

    public Meeting(long id, Person responsible, LocalDateTime start, LocalDateTime end, Room room) {

        if (start.isAfter(end)) {
            throw new RuntimeException("Dates error validation - id: " + id);
        }

        long durationInMin = ChronoUnit.MINUTES.between(start, end);

        if (durationInMin < 15 || durationInMin > 3*60) {
            throw new RuntimeException("Meeting duration error validation - id: " + id);
        }
        this.id = id;
        this.responsible = responsible;
        this.start = start;
        this.end = end;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getResponsible() {
        return responsible;
    }

    public void setResponsible(Person responsible) {
        this.responsible = responsible;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public int compareTo(Meeting o) {
        return start.compareTo(o.getStart());
    }
}
