package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.repository.CandidateRepository;
import by.mifort.automation.hr.dev.service.CandidateService;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final EntityConverter<Candidate, CandidateDto> converter;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository, EntityConverter<Candidate, CandidateDto> converter) {
        this.candidateRepository = candidateRepository;
        this.converter = converter;
    }

    @Override
    public List<CandidateDto> getAll(FilterDto filterDto) {
        List<Candidate> candidateList;
        Integer page = filterDto.getPageNumber();
        Integer amount = filterDto.getPageSize();
        Pageable pageable = PageRequest.of(page - 1, amount);
        if (filterDto.getKeyword() == null) {
            candidateList = candidateRepository.findAll(pageable).toList();
            return converter.convertToListEntityDto(candidateList);
        }
        candidateList = candidateRepository.findCandidatesByKeywordsContaining(filterDto.getKeyword().get(0), pageable);
        return converter.convertToListEntityDto(candidateList);
    }

    @Override
    @Transactional
    public CandidateDto getById(@NotNull String id) {
        Candidate candidate = candidateRepository
                .findCandidateWithoutArchivedHistory(id)
                .orElseThrow(() -> new EntityNotFoundException("Candidate with id: " + id + " do not exists!"));

        return converter.convertToEntityDto(candidate);
    }

    @Override
    @Transactional
    public void create(@NotNull CandidateDto candidateDto) {
        Candidate candidate = converter.convertToEntity(candidateDto);
        candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> findByKeywords(@NotNull Set<Keyword> keywords) {
        return new ArrayList<>();
    }

    @Override
    public List<Candidate> findByAttributes(@NotNull Set<CandidateAttributes> attributes) {
        return new ArrayList<>();
    }
}
