package com.sliit.goldenpalmresort.repository;

import com.sliit.goldenpalmresort.model.RefundRequest;
import com.sliit.goldenpalmresort.model.RefundRequest.RefundStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RefundRequestRepository extends MongoRepository<RefundRequest, String> {
    
    List<RefundRequest> findByStatus(RefundStatus status);
    
    List<RefundRequest> findByUserId(String userId);
    
    Optional<RefundRequest> findByBookingReference(String bookingReference);
    
    List<RefundRequest> findByStatusOrderByCreatedAtDesc(RefundStatus status);
    
    List<RefundRequest> findAllByOrderByCreatedAtDesc();
    
    long countByStatus(RefundStatus status);
}
