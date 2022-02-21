package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.repository.CommunicationHistoryRepository;
import by.mifort.automation.hr.dev.service.CommunicationHistoryService;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
import by.mifort.automation.hr.dev.util.differences.AssertDifferencesUpdates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommunicationHistoryServiceImpl implements CommunicationHistoryService {

    private final CommunicationHistoryRepository repository;
    private final EntityConverter<CommunicationHistory, CommunicationHistoryDto> converter;
    private final AssertDifferencesUpdates assertDifferencesUpdates;

    @Autowired
    public CommunicationHistoryServiceImpl(CommunicationHistoryRepository repository, EntityConverter<CommunicationHistory, CommunicationHistoryDto> converter, AssertDifferencesUpdates assertDifferencesUpdates) {
        this.repository = repository;
        this.converter = converter;
        this.assertDifferencesUpdates = assertDifferencesUpdates;
    }

    @Override
    public List<CommunicationHistoryDto> getByCandidateId(String candidateId) {
        List<CommunicationHistory> communicationHistory = repository.findCommunicationHistoriesByCandidateId(candidateId);
        return converter.convertToListEntityDto(communicationHistory);
    }

    @Override
    @Transactional
    public CommunicationHistoryDto createByCandidateId(String candidateId, CommunicationHistory history) {
        Candidate candidate = new Candidate();
        candidate.setId(candidateId);
        history.setCandidate(candidate);
        repository.save(history);
        return converter.convertToEntityDto(history);
    }

    @Override
    @Transactional
    public CommunicationHistoryDto updateByCandidateId(String candidateId, CommunicationHistoryDto history) {
        if (history.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        CommunicationHistory communicationHistory = repository.findCommunicationHistoryByCandidateIdAndId(candidateId, history.getId());
        if (communicationHistory == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            communicationHistory = assertDifferencesUpdates.assertCommunicationHistoryAndDto(communicationHistory, history);
        }
        repository.save(communicationHistory);
        return converter.convertToEntityDto(communicationHistory);
    }

    @Override
    public CommunicationHistoryDto archiveByCandidateId(String candidateId) {
        return null;
    }
}
