package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.repository.CandidateRepository;

import java.util.List;
import java.util.Set;

/**
 * Service layer for validation and business logic for CandidateRepository
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see CandidateRepository
 */

public interface CandidateService {

    /**
     * @param filterDto dto with pagination, sortTypes
     * @return List of all exists paginated candidates
     * @see FilterDto
     */
    List<CandidateDto> getAll(FilterDto filterDto);

    /**
     * @param id identifier of candidate
     * @return information about candidate
     */
    CandidateDto getById(String id);

    /**
     * Create new candidate in database
     *
     * @param candidateDto body of our candidate
     */
    void create(CandidateDto candidateDto);

    /**
     * @param keywords keywords that connected with candidate
     * @return List of candidate by keyword(s)
     */
    List<Candidate> findByKeywords(Set<Keyword> keywords);

    /**
     * @param attributes attributes that connected with candidate
     * @return List of candidate by attribute(s)
     */
    List<Candidate> findByAttributes(Set<CandidateAttributes> attributes);
}
