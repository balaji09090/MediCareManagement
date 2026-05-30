package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // URL: POST http://localhost:8080/room/add
    @PostMapping("add")
    public ResponseEntity<String> addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
        return ResponseEntity.ok("Hospital room added to inventory successfully!");
    }

    // URL: GET http://localhost:8080/room/display
    @GetMapping("display")
    public List<Room> displayAllRooms() {
        return roomService.getAllRooms();
    }

    // URL: PUT http://localhost:8080/room/status/101?availability=false
    @PutMapping("status/{roomNumber}")
    public ResponseEntity<String> updateRoomStatus(
            @PathVariable Integer roomNumber, 
            @RequestParam boolean availability) {
        roomService.updateRoomAvailability(roomNumber, availability);
        return ResponseEntity.ok("Room " + roomNumber + " availability status updated to: " + availability);
    }
}
