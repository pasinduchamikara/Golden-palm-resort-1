package com.sliit.goldenpalmresort.repository;

import com.sliit.goldenpalmresort.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
    
    @Query("{ 'roomId': ?0, 'isActive': true }")
    List<Photo> findByRoomIdOrderByDisplayOrder(String roomId);
    
    @Query("{ 'eventSpaceId': ?0, 'isActive': true }")
    List<Photo> findByEventSpaceIdOrderByDisplayOrder(String eventSpaceId);
    
    long countByRoomIdAndIsActiveTrue(String roomId);
    
    long countByEventSpaceIdAndIsActiveTrue(String eventSpaceId);
} 