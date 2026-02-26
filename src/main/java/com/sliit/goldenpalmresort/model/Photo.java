package com.sliit.goldenpalmresort.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "photos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    private String id;
    private String fileName;
    private String originalFileName;
    private String contentType;
    private Long fileSize;
    private String filePath;
    private byte[] photoData;
    private Integer displayOrder;
    @JsonIgnore
    private String roomId;
    @JsonIgnore
    private String eventSpaceId;
    private Boolean isActive = true;
    private String uploadedBy;
    private java.time.LocalDateTime uploadedAt;
}
