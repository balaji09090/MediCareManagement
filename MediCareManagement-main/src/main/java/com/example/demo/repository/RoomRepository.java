package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    
    // Find rooms matching type and its boolean availability state
    List<Room> findByRoomTypeAndIsAvailable(String roomType, Boolean isAvailable);
    
    // Find all rooms based strictly on availability status
    List<Room> findByIsAvailable(Boolean isAvailable);
    
    // Lookup a room record by its explicit room string number (e.g., "101-A")
    java.util.Optional<Room> findByRoomNumber(String roomNumber);
}
