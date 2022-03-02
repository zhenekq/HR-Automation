package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CandidateAttributesDto;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.repository.AttributeTypesRepository;
import by.mifort.automation.hr.dev.repository.CandidateAttributesRepository;
import by.mifort.automation.hr.dev.repository.CandidateRepository;
import by.mifort.automation.hr.dev.service.CandidateAttributesService;
import by.mifort.automation.hr.dev.util.Utils;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
import by.mifort.automation.hr.dev.util.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CandidateAttributesServiceImpl implements CandidateAttributesService {

    private final CandidateAttributesRepository repository;
    private final CandidateRepository candidateRepository;
    private final AttributeTypesRepository typesRepository;
    private final EntityConverter<CandidateAttributes, CandidateAttributesDto> converter;
    private final EntityValidator<CandidateAttributes> validator;

    @Autowired
    public CandidateAttributesServiceImpl(CandidateAttributesRepository repository, CandidateRepository candidateRepository, AttributeTypesRepository typesRepository, EntityConverter<CandidateAttributes, CandidateAttributesDto> converter, EntityValidator<CandidateAttributes> validator) {
        this.repository = repository;
        this.candidateRepository = candidateRepository;
        this.typesRepository = typesRepository;
        this.converter = converter;
        this.validator = validator;
    }

    @Override
    public List<CandidateAttributes> getByCandidateId(String candidateId) {
        candidateRepository
                .findById(candidateId)
                .orElseThrow(()-> new EntityNotFoundException("Candidate with id: " + candidateId + " not found"));
        return repository.findCandidateAttributesByCandidateId(candidateId);
    }

    @Override
    @Transactional
    public CandidateAttributes createByCandidateIdAndAttributeTypeId(String candidateId, Integer attributeTypeId, CandidateAttributes attributes) {
        candidateRepository
                .findById(candidateId)
                .orElseThrow( () -> new EntityNotFoundException("Candidate exists"));
        typesRepository
                .findById(attributeTypeId)
                .orElseThrow(() -> new EntityNotFoundException("Attribute type not found!"));
        if(validator.isValidParams(attributes)) {
            Utils.setCandidateAttribute(candidateId, attributes, attributeTypeId);
            return repository.save(attributes);
        }
        throw new IllegalArgumentException("Entity params couldn't be nullable!");
    }
}
