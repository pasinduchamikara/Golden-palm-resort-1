package com.sliit.goldenpalmresort.repository;

import com.sliit.goldenpalmresort.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    
    List<Room> findByStatus(Room.RoomStatus status);
    
    List<Room> findByRoomType(String roomType);
    
    List<Room> findByIsActiveTrue();
    
    @Query("{ 'status': 'AVAILABLE', 'capacity': { $gte: ?0 } }")
    List<Room> findAvailableRoomsByCapacity(Integer guestCount);
    
    Room findByRoomNumber(String roomNumber);
    
    List<Room> findByCapacityGreaterThanEqual(Integer capacity);
}