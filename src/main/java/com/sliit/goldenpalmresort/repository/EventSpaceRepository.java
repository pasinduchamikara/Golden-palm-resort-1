package com.sliit.goldenpalmresort.repository;

import com.sliit.goldenpalmresort.model.EventSpace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventSpaceRepository extends MongoRepository<EventSpace, String> {
    
    List<EventSpace> findByStatus(EventSpace.EventSpaceStatus status);
    
    List<EventSpace> findByIsActiveTrue();
    
    @Query("{ 'capacity': { $gte: ?0, $lte: ?1 } }")
    List<EventSpace> findByCapacityRange(Integer minCapacity, Integer maxCapacity);
    
    @Query("{ 'setupTypes': { $regex: ?0 } }")
    List<EventSpace> findByEventType(String eventType);
    
    @Query("{ 'status': 'AVAILABLE', 'capacity': { $gte: ?3 } }")
    List<EventSpace> findAvailableEventSpaces(LocalDate eventDate,
                                            String startTime,
                                            String endTime,
                                            Integer expectedGuests);
    
    @Query("{ 'cateringAvailable': true }")
    List<EventSpace> findEventSpacesWithCatering();
    
    @Query("{ 'audioVisualEquipment': true }")
    List<EventSpace> findEventSpacesWithAudioVisual();
    
    EventSpace findByName(String name);
} 