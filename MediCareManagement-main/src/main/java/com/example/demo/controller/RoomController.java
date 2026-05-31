package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    
    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("add")
    public void add(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    @GetMapping("display")
    public List<Room> display() {
        return roomService.getAllRooms();
    }

    // Shows ONLY available rooms for drop-down selection forms
    // URL: GET http://localhost:8080/room/vacant?type=AC
    @GetMapping("vacant")
    public List<Room> getVacantRooms(@RequestParam String type) {
        return roomRepository.findByRoomTypeAndIsAvailable(type, true);
    }

    // Shows rooms currently occupied by admitted patients
    // URL: GET http://localhost:8080/room/occupied
    @GetMapping("occupied")
    public List<Room> getOccupiedRooms() {
        return roomRepository.findByIsAvailable(false);
    }
}
