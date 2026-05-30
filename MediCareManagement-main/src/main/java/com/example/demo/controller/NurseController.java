package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Nurse;
import com.example.demo.service.NurseService;

@RestController
@RequestMapping("nurse")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    // URL: POST http://localhost:8080/nurse/add
    @PostMapping("add")
    public ResponseEntity<String> addNurse(@RequestBody Nurse nurse) {
        nurseService.addNurse(nurse);
        return ResponseEntity.ok("Nurse hired and registered successfully!");
    }

    // URL: GET http://localhost:8080/nurse/display
    @GetMapping("display")
    public List<Nurse> displayAllNurses() {
        return nurseService.getAllNurses();
    }

    // URL: GET http://localhost:8080/nurse/search/1
    @GetMapping("search/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable Integer id) {
        Nurse nurse = nurseService.getNurseById(id);
        return ResponseEntity.ok(nurse);
    }

    // URL: DELETE http://localhost:8080/nurse/delete/1
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteNurse(@PathVariable Integer id) {
        nurseService.deleteNurse(id);
        return ResponseEntity.ok("Nurse record removed successfully.");
    }
}
