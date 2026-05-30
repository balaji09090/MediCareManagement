package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Room;

public interface RoomService {
	void addRoom(Room room);

	List<Room> getAllRooms();

	void updateRoomAvailability(Integer roomNumber, boolean availability);
}
