package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Nurse;
import com.example.demo.repository.NurseRepository;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Override
    public void addNurse(Nurse nurse) {
        if(nurse.getName() == null || nurse.getName().isEmpty()) {
            throw new RuntimeException("Nurse name cannot be empty");
        }
        nurseRepository.save(nurse);
    }

    @Override
    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse getNurseById(Integer id) {
        return nurseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nurse not found with ID: " + id));
    }


    @Override
    public void deleteNurse(Integer id) {
        nurseRepository.deleteById(id);
    }
}
