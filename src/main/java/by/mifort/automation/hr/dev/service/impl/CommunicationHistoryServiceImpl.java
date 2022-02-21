package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
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

import javax.persistence.EntityNotFoundException;
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
    public List<CommunicationHistoryDto> getByCandidateId(String candidateId, FilterDto filterDto) {
        List<CommunicationHistory> communicationHistory;
        if (filterDto.getIsArchived() == null || !filterDto.getIsArchived()) {
            communicationHistory = repository
                    .findCommunicationHistoriesByCandidateIdAndIsArchivedFalse(candidateId);
            return converter.convertToListEntityDto(communicationHistory);
        }
        communicationHistory = repository
                .findCommunicationHistoriesByCandidateIdAndIsArchivedTrue(candidateId);
        return converter.convertToListEntityDto(communicationHistory);
    }

    @Override
    @Transactional
    public CommunicationHistoryDto createByCandidateId(String candidateId, CommunicationHistoryDto historyDto) {
        CommunicationHistory history = converter.convertToEntity(historyDto);
        history.setCandidate(new Candidate());
        history.getCandidate().setId(candidateId);
        repository.save(history);
        return converter.convertToEntityDto(history);
    }

    @Override
    @Transactional
    public CommunicationHistoryDto updateByCandidateId(String candidateId, CommunicationHistoryDto historyDto) {
        if (historyDto.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        CommunicationHistory communicationHistory = repository
                .findCommunicationHistoryByCandidateIdAndId(candidateId, historyDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Communication history do not exists"));
        communicationHistory = assertDifferencesUpdates.assertCommunicationHistoryAndDto(communicationHistory, historyDto);
        repository.save(communicationHistory);
        return converter.convertToEntityDto(communicationHistory);
    }

    @Override
    public CommunicationHistoryDto archiveByCandidateId(String candidateId, Integer historyId) {
        CommunicationHistory communicationHistory = repository
                .findCommunicationHistoryByCandidateIdAndId(candidateId, historyId)
                .orElseThrow(() -> new EntityNotFoundException("Communication history do not exists"));
        communicationHistory.setArchived(Boolean.TRUE);
        repository.save(communicationHistory);
        return converter.convertToEntityDto(communicationHistory);
    }
}
