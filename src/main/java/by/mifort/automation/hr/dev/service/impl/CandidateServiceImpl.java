package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.repository.CandidateRepository;
import by.mifort.automation.hr.dev.service.CandidateService;
import by.mifort.automation.hr.dev.util.MappingDtoComponentConverter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final MappingDtoComponentConverter converter;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository, MappingDtoComponentConverter converter) {
        this.candidateRepository = candidateRepository;
        this.converter = converter;
    }

    @Override
    public List<CandidateDto> getAll(FilterDto filterDto, String keyword) {
        List<Candidate> candidateList;
        Integer page = filterDto.getPageNumber();
        Integer amount = filterDto.getPageSize();
        if (page == null || amount == null || page <= 0 || amount <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parameters cannot be nullable");
        }
        Pageable pageable = PageRequest.of(page - 1, amount);
        if (keyword == null || keyword.isEmpty()) {
            candidateList = candidateRepository.findAllPeople(pageable).toList();
            return converter.convertToListPeopleDto(candidateList);
        }
        candidateList = candidateRepository.findAllByHumanKeywords(keyword, pageable);
        return converter.convertToListPeopleDto(candidateList);
    }

    @Override
    public CandidateDto getById(@NotNull String id) {
        Candidate candidate = candidateRepository.getById(id);
        return converter.convertToPeopleDto(candidate);
    }

    @Override
    @Transactional
    public void create(@NotNull Candidate candidate) {
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
