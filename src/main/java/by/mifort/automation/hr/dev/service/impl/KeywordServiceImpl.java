package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.KeywordDto;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.repository.KeywordRepository;
import by.mifort.automation.hr.dev.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {

    private final KeywordRepository repository;
    private final Integer AMOUNT_OF_RESULTS_ON_ONE_PAGE = 2;

    @Autowired
    public KeywordServiceImpl(KeywordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Keyword> getAllKeywords(Integer page) {
        if(page == null){
            return repository.findAll();
        }
        Pageable pageable = PageRequest.of(page - 1, AMOUNT_OF_RESULTS_ON_ONE_PAGE);
        return repository.findAllKeywords(pageable).toList();
    }

    @Override
    public List<Keyword> getAllKeywordsById(String id) {
        return repository.findById(id).stream().toList();
    }
}
