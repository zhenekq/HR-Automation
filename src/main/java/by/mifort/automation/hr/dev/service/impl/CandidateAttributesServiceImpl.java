package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CandidateAttributesDto;
import by.mifort.automation.hr.dev.entity.AttributeTypes;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.repository.CandidateAttributesRepository;
import by.mifort.automation.hr.dev.service.CandidateAttributesService;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandidateAttributesServiceImpl implements CandidateAttributesService {

    private final CandidateAttributesRepository repository;
    private final EntityConverter<CandidateAttributes, CandidateAttributesDto> converter;

    @Autowired
    public CandidateAttributesServiceImpl(CandidateAttributesRepository repository, EntityConverter<CandidateAttributes, CandidateAttributesDto> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<CandidateAttributes> getByCandidateId(String candidateId) {
        List<CandidateAttributes> attributes = repository.findCandidateAttributesByCandidateId(candidateId);
        return attributes;
    }

    @Override
    @Transactional
    public CandidateAttributes createByCandidateIdAndAttributeTypeId(String candidateId, Integer attributeTypeId, CandidateAttributes attributes) {
        Candidate candidate = new Candidate();
        candidate.setId(candidateId);
        attributes.setCandidate(candidate);
        AttributeTypes types = new AttributeTypes();
        types.setId(attributeTypeId);
        attributes.setAttributeTypes(types);
        repository.save(attributes);
        return attributes;
    }
}
