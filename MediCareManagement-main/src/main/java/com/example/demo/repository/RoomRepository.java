package com.example.demo.repository;

	import java.util.Optional;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;
	import com.example.demo.model.Room;
	@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
	
	    // This custom helper query searches your database for the first empty room matching a specific type
	    Optional<Room> findFirstByRoomTypeAndIsAvailableTrue(String roomType);
	}

