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
        // Automatically mark new physical inventory rooms as available
        if (room.getIsAvailable() == null) {
            room.setIsAvailable(true);
        }
        
        
        roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void updateRoomAvailability(Integer id, boolean availability) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + id));
        room.setIsAvailable(availability);
        roomRepository.save(room);
    }

    // AUTOMATION: Find an open room by type, lock it down, and flag it as false (Occupied)
    public Room bookAvailableRoom(String roomType) {
        List<Room> freeRooms = roomRepository.findByRoomTypeAndIsAvailable(roomType, true);
        
        if (freeRooms.isEmpty()) {
            throw new RuntimeException("No vacant rooms available for category: " + roomType);
        }
        
        Room roomToAssign = freeRooms.get(0);
        roomToAssign.setIsAvailable(false); // Flip to occupied
        return roomRepository.save(roomToAssign);
    }
}

