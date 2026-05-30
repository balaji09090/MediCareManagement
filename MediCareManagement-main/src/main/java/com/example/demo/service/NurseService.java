package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Nurse;

public interface NurseService {
	void addNurse(Nurse nurse);

	List<Nurse> getAllNurses();

	Nurse getNurseById(Integer id);

	void deleteNurse(Integer id);
}
