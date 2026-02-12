package com.example.boothsurvey.service;
import com.example.boothsurvey.model.*;
import com.example.boothsurvey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class SurveyService {
    @Autowired private SurveyRepository repository;

    public Survey submitSurvey(Survey survey, String username) {
        if (repository.existsByBoothIdAndVoterEpic(survey.getBoothId(), survey.getVoterEpic())) {
            throw new RuntimeException("Voter already submitted for this booth");
        }
        if (repository.existsByBoothIdAndSubmittedBy(survey.getBoothId(), username)) {
            throw new RuntimeException("Volunteer already submitted for this booth");
        }
        survey.setSubmittedBy(username);
        survey.setSubmittedAt(LocalDateTime.now());
        survey.setStatus(SurveyStatus.PENDING);
        return repository.save(survey);
    }

    public Survey approveSurvey(Long id, String username) {
        Survey survey = repository.findById(id).orElseThrow();
        if (survey.getStatus() == SurveyStatus.APPROVED) throw new RuntimeException("Already approved");
        survey.setStatus(SurveyStatus.APPROVED);
        survey.setApprovedBy(username);
        survey.setApprovedAt(LocalDateTime.now());
        return repository.save(survey);
    }
}