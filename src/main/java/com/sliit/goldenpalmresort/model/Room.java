package com.sliit.goldenpalmresort.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@Document(collection = "rooms")
public class Room {
    
    @Id
    private String id;
    private String roomNumber;
    private String roomType;
    private Integer floorNumber;
    private BigDecimal basePrice;
    private Integer capacity;
    private String description;
    private String amenities;
    private RoomStatus status = RoomStatus.AVAILABLE;
    private boolean isActive = true;
    private String imageUrls; // Comma-separated URLs
    private List<String> photoIds = new ArrayList<>();
    
    public enum RoomStatus {
        AVAILABLE, OCCUPIED, MAINTENANCE, BLOCKED
    }
    
    // Constructors
    public Room() {}
    
    public Room(String roomNumber, String roomType, Integer floorNumber, BigDecimal basePrice, Integer capacity) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floorNumber = floorNumber;
        this.basePrice = basePrice;
        this.capacity = capacity;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    
    public Integer getFloorNumber() { return floorNumber; }
    public void setFloorNumber(Integer floorNumber) { this.floorNumber = floorNumber; }
    
    public BigDecimal getBasePrice() { return basePrice; }
    public void setBasePrice(BigDecimal basePrice) { this.basePrice = basePrice; }
    
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getAmenities() { return amenities; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
    
    public RoomStatus getStatus() { return status; }
    public void setStatus(RoomStatus status) { this.status = status; }
    
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    
    public String getImageUrls() { return imageUrls; }
    public void setImageUrls(String imageUrls) { this.imageUrls = imageUrls; }
    
    public List<String> getPhotoIds() { return photoIds; }
    public void setPhotoIds(List<String> photoIds) { this.photoIds = photoIds; }
} 