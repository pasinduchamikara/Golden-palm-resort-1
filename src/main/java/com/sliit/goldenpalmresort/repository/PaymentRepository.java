package com.sliit.goldenpalmresort.repository;

import com.sliit.goldenpalmresort.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    
    List<Payment> findByPaymentStatus(Payment.PaymentStatus status);
    
    List<Payment> findByPaymentMethod(Payment.PaymentMethod paymentMethod);
    
    List<Payment> findByBookingId(String bookingId);
    
    List<Payment> findByEventBookingId(String eventBookingId);
    
    @Query("{ 'paymentDate': { $gte: ?0, $lte: ?1 } }")
    List<Payment> findByPaymentDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    @Query("{ 'amount': { $gte: ?0, $lte: ?1 } }")
    List<Payment> findByAmountBetween(BigDecimal minAmount, BigDecimal maxAmount);
    
    @Query("{ 'paymentStatus': 'COMPLETED', 'paymentDate': { $gte: ?0, $lte: ?1 } }")
    List<Payment> findCompletedPaymentsByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    
    long countByPaymentStatus(Payment.PaymentStatus status);
    
    List<Payment> findByProcessedBy(String processedBy);
    
    @Query("{ 'refundAmount': { $exists: true, $gt: 0 } }")
    List<Payment> findPaymentsWithRefunds();
    
    Optional<Payment> findByBookingId(String bookingId);
    
    Optional<Payment> findByEventBookingId(String eventBookingId);
} 