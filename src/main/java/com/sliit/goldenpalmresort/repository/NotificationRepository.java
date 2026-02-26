package com.sliit.goldenpalmresort.repository;

import com.sliit.goldenpalmresort.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
    
    List<Notification> findByUserIdOrderByCreatedAtDesc(String userId);
    
    List<Notification> findByUserIdAndIsReadFalseOrderByCreatedAtDesc(String userId);
    
    List<Notification> findByType(Notification.NotificationType type);
    
    List<Notification> findByUserIdAndTypeOrderByCreatedAtDesc(String userId, Notification.NotificationType type);
    
    long countByUserIdAndIsReadFalse(String userId);
    
    @Query("{ 'referenceId': ?0, 'referenceType': ?1 }")
    List<Notification> findByReference(String referenceId, String referenceType);
    
    List<Notification> findBySentByOrderByCreatedAtDesc(String sentBy);
}
