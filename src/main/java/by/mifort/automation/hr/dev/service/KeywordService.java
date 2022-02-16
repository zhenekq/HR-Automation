package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.entity.Keyword;

import java.util.List;

/**
 * Service layer for validation and business logic KeywordsRepository
 * @see by.mifort.automation.hr.dev.repository.KeywordRepository
 * @author yauheni_vozny
 * @version 1.0
 * */

public interface KeywordService {

    /**
     * @return List of all exists paginated keywords
     * @param page number of page to see keywords
     */
    List<Keyword> getAllKeywords(Integer page);

    List<Keyword> getAllKeywordsById(String id);

}
