package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CandidateAttributesDto;
import by.mifort.automation.hr.dev.entity.AttributeTypes;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.repository.AttributeTypesRepository;
import by.mifort.automation.hr.dev.repository.CandidateAttributesRepository;
import by.mifort.automation.hr.dev.repository.CandidateRepository;
import by.mifort.automation.hr.dev.service.CandidateAttributesService;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
import by.mifort.automation.hr.dev.util.differences.impl.AsserDifferencesCandidateListAttributes;
import by.mifort.automation.hr.dev.util.validator.EntityValidator;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class CandidateAttributesServiceImpl implements CandidateAttributesService {

    private final CandidateAttributesRepository repository;
    private final CandidateRepository candidateRepository;
    private final AttributeTypesRepository typesRepository;
    private final EntityConverter<CandidateAttributes, CandidateAttributesDto> converter;
    private final EntityValidator<List<CandidateAttributes>> validator;

    @Autowired
    public CandidateAttributesServiceImpl(CandidateAttributesRepository repository, CandidateRepository candidateRepository, AttributeTypesRepository typesRepository, EntityConverter<CandidateAttributes, CandidateAttributesDto> converter, EntityValidator<List<CandidateAttributes>> validator) {
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
        return repository.findAllByCandidateId(candidateId);
    }

    @Override
    @Transactional
    public List<CandidateAttributes> createByCandidateId(String candidateId, List<CandidateAttributes> attributes) {
        List<CandidateAttributes> candidateAttributes = getByCandidateId(candidateId);
        candidateRepository
                .findById(candidateId)
                .orElseThrow( () -> new EntityNotFoundException("Candidate not exists"));
        attributes.forEach(
                p -> p.setCandidate(new Candidate(candidateId))
        );
        attributes.forEach(
                attribute -> typesRepository
                        .findById(attribute.getAttributeTypes().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Attribute type not found!"))
        );
        if(validator.isValidParams(attributes)){
            List<CandidateAttributes> attr = AsserDifferencesCandidateListAttributes.assertDiff(
                    candidateAttributes, attributes);
            return repository.saveAll(attr);
        }
        throw new IllegalArgumentException("Entity params couldn't be nullable!");
    }
}
