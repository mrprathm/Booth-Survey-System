package com.example.boothsurvey.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Survey {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String boothId;
    private String voterEpic;
    @Column(columnDefinition = "TEXT")
    private String responses; // Store as JSON string or flat fields
    private String submittedBy;
    private LocalDateTime submittedAt;
    @Enumerated(EnumType.STRING)
    private SurveyStatus status;
    private String approvedBy;
    private LocalDateTime approvedAt;
}