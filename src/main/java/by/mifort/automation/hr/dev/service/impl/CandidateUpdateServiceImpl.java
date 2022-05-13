package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.entity.CandidateUpdate;
import by.mifort.automation.hr.dev.repository.CandidateUpdateRepository;
import by.mifort.automation.hr.dev.service.CandidateUpdatesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateUpdateServiceImpl implements CandidateUpdatesService {

    private final CandidateUpdateRepository repository;

    public CandidateUpdateServiceImpl(CandidateUpdateRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<CandidateUpdate> getByCandidateId(String candidateId) {
        return repository
                .findAllByCandidateId(candidateId)
                .stream()
                .toList();
    }

    @Override
    public CandidateUpdate createByCandidateId(String candidateId, CandidateUpdate update) {
        return null;
    }
}
