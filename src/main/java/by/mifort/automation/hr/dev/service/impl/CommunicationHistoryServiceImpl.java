package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.repository.CommunicationHistoryRepository;
import by.mifort.automation.hr.dev.service.CommunicationHistoryService;
import by.mifort.automation.hr.dev.util.MappingDtoComponentConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommunicationHistoryServiceImpl implements CommunicationHistoryService {

    private final CommunicationHistoryRepository repository;
    private final MappingDtoComponentConverter converter;

    public CommunicationHistoryServiceImpl(CommunicationHistoryRepository repository, MappingDtoComponentConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<CommunicationHistoryDto> getHistoryByCandidateId(String id) {
        List<CommunicationHistory> communicationHistory = repository.findCommunicationHistoriesByCandidateId(id);
        return converter.convertToListCommunicationHistoryDto(communicationHistory);
    }

    @Override
    @Transactional
    public CommunicationHistoryDto createHistoryWithCandidate(String id, CommunicationHistory history) {
        Candidate candidate = new Candidate();
        candidate.setId(id);
        history.setCandidate(candidate);
        repository.save(history);
        return converter.convertToCommunicationHistoryDto(history);
    }

    @Override
    public CommunicationHistoryDto updateHistoryWithCandidate(String id, CommunicationHistory history) {
        return null;
    }

    @Override
    public CommunicationHistoryDto archiveHistoryWithCandidate(String id, CommunicationHistory history) {
        return null;
    }
}
