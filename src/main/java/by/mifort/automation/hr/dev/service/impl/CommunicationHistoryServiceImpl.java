package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.repository.CommunicationHistoryRepository;
import by.mifort.automation.hr.dev.service.CommunicationHistoryService;
import by.mifort.automation.hr.dev.util.differences.AssertDifferencesUpdates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CommunicationHistoryServiceImpl implements CommunicationHistoryService {

    private final CommunicationHistoryRepository repository;
    private final AssertDifferencesUpdates assertDifferencesUpdates;

    @Autowired
    public CommunicationHistoryServiceImpl(CommunicationHistoryRepository repository, AssertDifferencesUpdates assertDifferencesUpdates) {
        this.repository = repository;
        this.assertDifferencesUpdates = assertDifferencesUpdates;
    }

    @Override
    public List<CommunicationHistory> getByCandidateId(String candidateId, FilterDto filterDto) {
        List<CommunicationHistory> communicationHistory;
        if (filterDto.getIsArchived() == null || !filterDto.getIsArchived()) {
            communicationHistory = repository
                    .findCommunicationHistoriesByCandidateIdAndIsArchivedEquals(candidateId, Boolean.FALSE);
            return communicationHistory;
        }
        communicationHistory = repository
                .findCommunicationHistoriesByCandidateIdAndIsArchivedEquals(candidateId, Boolean.TRUE);
        return communicationHistory;
    }

    @Override
    @Transactional
    public CommunicationHistory createByCandidateId(String candidateId, CommunicationHistory history) {
        history.setCandidate(new Candidate());
        history.getCandidate().setId(candidateId);
        history.setArchived(Boolean.FALSE);
        repository.save(history);
        return history;
    }

    @Override
    @Transactional
    public CommunicationHistory updateByCandidateId(String candidateId, CommunicationHistoryDto historyDto) {
        if (historyDto.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        CommunicationHistory communicationHistory = repository
                .findCommunicationHistoryByCandidateIdAndId(candidateId, historyDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Communication history do not exists"));
        communicationHistory = assertDifferencesUpdates.assertCommunicationHistoryAndDto(communicationHistory, historyDto);
        repository.save(communicationHistory);
        return communicationHistory;
    }

    @Override
    public CommunicationHistory archiveByCandidateId(String candidateId, Integer historyId) {
        CommunicationHistory communicationHistory = repository
                .findCommunicationHistoryByCandidateIdAndId(candidateId, historyId)
                .orElseThrow(() -> new EntityNotFoundException("Communication history do not exists"));
        communicationHistory.setArchived(Boolean.TRUE);
        repository.save(communicationHistory);
        return communicationHistory;
    }
}
