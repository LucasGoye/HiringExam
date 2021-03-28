package com.goyeneche.services;

import com.goyeneche.models.Meeting;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MeetingService {

    public boolean validateSchedule(List<Meeting> meetings){
            Map<Long, List<Meeting>> meetingsByRoom = meetings.stream().collect(Collectors.groupingBy(m -> m.getRoom().getId()));
            for (List<Meeting> m : meetingsByRoom.values()) {
                if (!validateScheduleByRooms(m)) {
                    return false;
                }
        }
            return true;
    }

    public boolean validateScheduleByRooms(List<Meeting> meetings) {
            meetings.sort((m1, m2) -> m1.compareTo(m2));
            for (int i = 0; i < meetings.size() - 1; i++) {
                if (meetings.get(i).getEnd().isAfter(meetings.get(i+1).getStart())) {
                    return false;
                }
            }
            return true;
    }
}
