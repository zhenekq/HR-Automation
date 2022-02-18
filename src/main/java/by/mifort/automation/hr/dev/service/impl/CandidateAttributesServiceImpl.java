package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CandidateAttributesDto;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.repository.CandidateAttributesRepository;
import by.mifort.automation.hr.dev.service.CandidateAttributesService;
import by.mifort.automation.hr.dev.util.MappingDtoComponentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateAttributesServiceImpl implements CandidateAttributesService {

    private final CandidateAttributesRepository repository;
    private final MappingDtoComponentConverter converter;

    @Autowired
    public CandidateAttributesServiceImpl(CandidateAttributesRepository repository, MappingDtoComponentConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<CandidateAttributesDto> getByCandidateId(String candidateId) {
        List<CandidateAttributes> attributes = repository.findCandidateAttributesByCandidateId(candidateId);
        return converter.convertToListCandidateAttributesDto(attributes);
    }

    @Override
    public CandidateAttributesDto createByCandidateId(String candidateId, CandidateAttributes attributes) {
        return null;
    }

    @Override
    public CandidateAttributesDto updateByCandidateId(String candidateId, CandidateAttributes attributes) {
        return null;
    }

    @Override
    public CandidateAttributesDto archiveByCandidateId(String candidateId) {
        return null;
    }
}
