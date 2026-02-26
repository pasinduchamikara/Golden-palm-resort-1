package com.sliit.goldenpalmresort.repository;

import com.sliit.goldenpalmresort.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends MongoRepository<Booking, String> {
    
    Optional<Booking> findByBookingReference(String bookingReference);
    
    List<Booking> findByUserId(String userId);
    
    List<Booking> findByStatus(Booking.BookingStatus status);
    
    @Query("{ 'roomId': ?0, 'status': { $ne: 'CANCELLED' }, 'checkInDate': { $lte: ?2 }, 'checkOutDate': { $gte: ?1 } }")
    List<Booking> findOverlappingBookings(
            String roomId,
            LocalDate checkInDate,
            LocalDate checkOutDate);
            
    @Query("{ 'checkInDate': { $gte: ?0, $lte: ?1 } }")
    List<Booking> findByCheckInDateBetween(
            LocalDate startDate,
            LocalDate endDate);
            
    @Query("{ 'status': ?0, 'checkInDate': { $gte: ?1, $lte: ?2 } }")
    List<Booking> findByStatusAndCheckInDateBetween(
            Booking.BookingStatus status,
            LocalDate startDate,
            LocalDate endDate);
}