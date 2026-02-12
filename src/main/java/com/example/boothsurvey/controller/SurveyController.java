package com.example.boothsurvey.controller;
import com.example.boothsurvey.model.Survey;
import com.example.boothsurvey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
    @Autowired private SurveyService service;

    @PostMapping
    @PreAuthorize("hasRole('VOLUNTEER')")
    public Survey create(@RequestBody Survey survey) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return service.submitSurvey(survey, username);
    }

    @PostMapping("/{id}/approve")
    @PreAuthorize("hasRole('ADMIN')")
    public Survey approve(@PathVariable Long id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return service.approveSurvey(id, username);
    }
}