package com.example.boothsurvey.dto;
import lombok.Data;
import java.util.Map;
@Data public class AnalyticsResponse {
    private long totalSurveys;
    private long approvedSurveys;
    private long pendingSurveys;
    private Map<String, Long> boothCoverage;
}