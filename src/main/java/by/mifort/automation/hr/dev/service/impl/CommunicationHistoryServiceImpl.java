package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.repository.CommunicationHistoryRepository;
import by.mifort.automation.hr.dev.service.CommunicationHistoryService;
import by.mifort.automation.hr.dev.util.MappingDtoComponentConverter;
import com.skillbox.airport.Airport;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        List<CommunicationHistory> communicationHistory = repository.findCommunicationHistoriesByHumanId(id);
        return converter.convertToListCommunicationHistoryDto(communicationHistory);
    }

    @Override
    public CommunicationHistoryDto createHistoryWithCandidate(String id, CommunicationHistory history) {
        return null;
    }
}
