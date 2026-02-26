package com.sliit.goldenpalmresort.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@Document(collection = "event_spaces")
public class EventSpace {
    
    @Id
    private String id;
    private String name;
    private String description;
    private Integer capacity;
    private BigDecimal basePrice;
    private String setupTypes;
    private String amenities;
    private Integer floorNumber;
    private String dimensions;
    private boolean cateringAvailable = false;
    private boolean audioVisualEquipment = false;
    private boolean parkingAvailable = false;
    private EventSpaceStatus status = EventSpaceStatus.AVAILABLE;
    private boolean isActive = true;
    private String imageUrls;
    private List<String> photoIds = new ArrayList<>();
    
    public enum EventSpaceStatus {
        AVAILABLE, BOOKED, MAINTENANCE, BLOCKED
    }
    
    // Constructors
    public EventSpace() {}
    
    public EventSpace(String name, String description, Integer capacity, BigDecimal basePrice) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.basePrice = basePrice;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    
    public BigDecimal getBasePrice() { return basePrice; }
    public void setBasePrice(BigDecimal basePrice) { this.basePrice = basePrice; }
    
    public String getSetupTypes() { return setupTypes; }
    public void setSetupTypes(String setupTypes) { this.setupTypes = setupTypes; }
    
    public String getAmenities() { return amenities; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
    
    public Integer getFloorNumber() { return floorNumber; }
    public void setFloorNumber(Integer floorNumber) { this.floorNumber = floorNumber; }
    
    public String getDimensions() { return dimensions; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }
    
    public boolean isCateringAvailable() { return cateringAvailable; }
    public void setCateringAvailable(boolean cateringAvailable) { this.cateringAvailable = cateringAvailable; }
    
    public boolean isAudioVisualEquipment() { return audioVisualEquipment; }
    public void setAudioVisualEquipment(boolean audioVisualEquipment) { this.audioVisualEquipment = audioVisualEquipment; }
    
    public boolean isParkingAvailable() { return parkingAvailable; }
    public void setParkingAvailable(boolean parkingAvailable) { this.parkingAvailable = parkingAvailable; }
    
    public EventSpaceStatus getStatus() { return status; }
    public void setStatus(EventSpaceStatus status) { this.status = status; }
    
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    
    public String getImageUrls() { return imageUrls; }
    public void setImageUrls(String imageUrls) { this.imageUrls = imageUrls; }
    
    public List<String> getPhotoIds() { return photoIds; }
    public void setPhotoIds(List<String> photoIds) { this.photoIds = photoIds; }
} 