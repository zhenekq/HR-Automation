package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.repository.CandidateRepository;
import by.mifort.automation.hr.dev.service.CandidateService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Candidate> getAll(FilterDto filterDto) {
        List<Candidate> candidateList;
        Integer page = filterDto.getPageNumber();
        Integer amount = filterDto.getPageSize();
        Pageable pageable = PageRequest.of(page - 1, amount);
        if (filterDto.getKeyword() == null) {
            candidateList = candidateRepository.findAll(pageable).toList();
            return candidateList;
        }
        candidateList = candidateRepository.findCandidatesByKeywordsContaining(filterDto.getKeyword().get(0), pageable);
        return candidateList;
    }

    @Override
    @Transactional
    public Candidate getById(@NotNull String id) {
        return candidateRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Candidate with id: " + id + " not found!"));
    }

    @Override
    @Transactional
    public Candidate create(@NotNull Candidate candidate) {
        return candidateRepository
                .findById(candidate.getId())
                .orElse(candidateRepository.save(candidate));
    }
}
