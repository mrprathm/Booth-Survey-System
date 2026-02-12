package com.example.boothsurvey.repository;
import com.example.boothsurvey.model.Survey;
import com.example.boothsurvey.model.SurveyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    boolean existsByBoothIdAndVoterEpic(String boothId, String voterEpic);
    boolean existsByBoothIdAndSubmittedBy(String boothId, String submittedBy);
    
    @Query("SELECT COUNT(s) FROM Survey s WHERE s.submittedAt BETWEEN :from AND :to")
    long countByDateRange(LocalDateTime from, LocalDateTime to);
    
    @Query("SELECT COUNT(s) FROM Survey s WHERE s.status = :status AND s.submittedAt BETWEEN :from AND :to")
    long countByStatusAndDateRange(SurveyStatus status, LocalDateTime from, LocalDateTime to);
    
    @Query("SELECT s.boothId, COUNT(s) FROM Survey s WHERE s.submittedAt BETWEEN :from AND :to GROUP BY s.boothId")
    List<Object[]> getBoothCoverage(LocalDateTime from, LocalDateTime to);
}