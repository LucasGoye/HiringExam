package com.goyeneche.services;

import com.goyeneche.models.Room;

import java.util.Arrays;
import java.util.List;

public class RoomService {

    public List<Room> getRooms() {
        Room room1 = new Room(1l, "Room 1", "Room 1 desc");
        Room room2 = new Room(2l, "Room 2", "Room 2 desc");
        Room room3 = new Room(3l, "Room 3", "Room 3 desc");
        return Arrays.asList(room1, room2, room3);
    }
}
