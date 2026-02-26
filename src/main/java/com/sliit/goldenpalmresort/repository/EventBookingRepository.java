package com.sliit.goldenpalmresort.repository;

import com.sliit.goldenpalmresort.model.EventBooking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventBookingRepository extends MongoRepository<EventBooking, String> {
    
    Optional<EventBooking> findByBookingReference(String bookingReference);
    
    List<EventBooking> findByUserId(String userId);
    
    @Query("{ 'eventSpaceId': ?0, 'eventDate': ?1, $or: [ { 'startTime': { $lte: ?2 }, 'endTime': { $gt: ?2 } }, { 'startTime': { $lt: ?3 }, 'endTime': { $gte: ?3 } }, { 'startTime': { $gte: ?2 }, 'endTime': { $lte: ?3 } } ] }")
    List<EventBooking> findConflictingEventBookings(String eventSpaceId,
                                                   LocalDate eventDate,
                                                   String startTime,
                                                   String endTime);
    
    List<EventBooking> findByStatus(EventBooking.EventBookingStatus status);
    
    @Query("{ 'eventDate': { $gte: ?0, $lte: ?1 } }")
    List<EventBooking> findEventBookingsByDateRange(LocalDate startDate,
                                                   LocalDate endDate);
    
    List<EventBooking> findByEventType(String eventType);
    
    List<EventBooking> findByEventDate(LocalDate eventDate);
} 