package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void addRoom(Room room) {
        // Automatically set new rooms to available upon construction
        if(room.getIsAvailable() == null) {
            room.setIsAvailable(true);
        }
        roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void updateRoomAvailability(Integer roomNumber, boolean availability) {
        Room room = roomRepository.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room number not found: " + roomNumber));
        room.setIsAvailable(availability);
        roomRepository.save(room);
    }
}
