package com.example.boothsurvey.controller;
import com.example.boothsurvey.dto.AnalyticsResponse;
import com.example.boothsurvey.model.SurveyStatus;
import com.example.boothsurvey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    @Autowired private SurveyRepository repository;

    @GetMapping("/booths")
    @PreAuthorize("hasRole('ADMIN')")
    public AnalyticsResponse getAnalytics(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        var start = from.atStartOfDay();
        var end = to.plusDays(1).atStartOfDay();
        
        AnalyticsResponse res = new AnalyticsResponse();
        res.setTotalSurveys(repository.countByDateRange(start, end));
        res.setApprovedSurveys(repository.countByStatusAndDateRange(SurveyStatus.APPROVED, start, end));
        res.setPendingSurveys(repository.countByStatusAndDateRange(SurveyStatus.PENDING, start, end));
        
        Map<String, Long> coverage = new HashMap<>();
        repository.getBoothCoverage(start, end).forEach(obj -> coverage.put((String)obj[0], (Long)obj[1]));
        res.setBoothCoverage(coverage);
        
        return res;
    }
}