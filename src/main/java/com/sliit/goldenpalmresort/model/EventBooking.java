package com.sliit.goldenpalmresort.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "event_bookings")
public class EventBooking {
    
    @Id
    private String id;
    private String bookingReference;
    private String userId;
    private String eventSpaceId;
    private String eventType;
    private LocalDate eventDate;
    private String startTime;
    private String endTime;
    private Integer expectedGuests;
    private BigDecimal totalAmount;
    private EventBookingStatus status = EventBookingStatus.PENDING;
    private String setupRequirements;
    private boolean cateringRequired = false;
    private boolean audioVisualRequired = false;
    private String specialRequests;
    private String contactPerson;
    private String contactPhone;
    private String contactEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public enum EventBookingStatus {
        PENDING, CONFIRMED, IN_PROGRESS, COMPLETED, CANCELLED
    }
    
    // Constructors
    public EventBooking() {}
    
    public EventBooking(String userId, String eventSpaceId, String eventType, LocalDate eventDate, 
                       String startTime, String endTime, Integer expectedGuests) {
        this.userId = userId;
        this.eventSpaceId = eventSpaceId;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.expectedGuests = expectedGuests;
        this.bookingReference = generateBookingReference();
    }
    
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (bookingReference == null) {
            bookingReference = generateBookingReference();
        }
    }
    
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    private String generateBookingReference() {
        return "EV" + LocalDateTime.now().getYear() + 
               String.format("%02d", LocalDateTime.now().getMonthValue()) +
               String.format("%02d", LocalDateTime.now().getDayOfMonth()) +
               String.format("%03d", (int)(Math.random() * 1000));
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getBookingReference() { return bookingReference; }
    public void setBookingReference(String bookingReference) { this.bookingReference = bookingReference; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getEventSpaceId() { return eventSpaceId; }
    public void setEventSpaceId(String eventSpaceId) { this.eventSpaceId = eventSpaceId; }
    
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    
    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }
    
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    
    public Integer getExpectedGuests() { return expectedGuests; }
    public void setExpectedGuests(Integer expectedGuests) { this.expectedGuests = expectedGuests; }
    
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    
    public EventBookingStatus getStatus() { return status; }
    public void setStatus(EventBookingStatus status) { this.status = status; }
    
    public String getSetupRequirements() { return setupRequirements; }
    public void setSetupRequirements(String setupRequirements) { this.setupRequirements = setupRequirements; }
    
    public boolean isCateringRequired() { return cateringRequired; }
    public void setCateringRequired(boolean cateringRequired) { this.cateringRequired = cateringRequired; }
    
    public boolean isAudioVisualRequired() { return audioVisualRequired; }
    public void setAudioVisualRequired(boolean audioVisualRequired) { this.audioVisualRequired = audioVisualRequired; }
    
    public String getSpecialRequests() { return specialRequests; }
    public void setSpecialRequests(String specialRequests) { this.specialRequests = specialRequests; }
    
    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    
    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
    
    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public boolean isCateringRequired() { return cateringRequired; }
    public void setCateringRequired(boolean cateringRequired) { this.cateringRequired = cateringRequired; }
    
    public boolean isAudioVisualRequired() { return audioVisualRequired; }
    public void setAudioVisualRequired(boolean audioVisualRequired) { this.audioVisualRequired = audioVisualRequired; }
    
    public String getSpecialRequests() { return specialRequests; }
    public void setSpecialRequests(String specialRequests) { this.specialRequests = specialRequests; }
    
    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    
    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
    
    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
} 