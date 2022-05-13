package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.repository.CommunicationHistoryRepository;
import by.mifort.automation.hr.dev.service.CommunicationHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationHistoryServiceImpl implements CommunicationHistoryService {

    private final CommunicationHistoryRepository repository;

    public CommunicationHistoryServiceImpl(CommunicationHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CommunicationHistory> findByOrderByCreateDateDesc() {
        return repository.findByOrderByUpdateDateDesc();
    }
}
