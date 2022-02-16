package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.repository.CandidateRepository;

import java.util.List;
import java.util.Set;

/**
 * Service layer for validation and business logic for PeopleRepository
 * @see CandidateRepository
 * @author yauheni_vozny
 * @version 1.0
 */

public interface CandidateService {

    /**
     * @return List of all exists paginated candidates
     * @param page number of page to see candidates
     */
    List<CandidateDto> getAllPeople(Integer page, Integer amount, String keyword);

    /**
     * @return information about candidate
     * @param id identifier of candidate
     */
    CandidateDto getHumanById(String id);

    /**
     * Create new candidate in database
     * @param candidate body of our candidate
     */
    void addNewHuman(Candidate candidate);

    /**
     * @return List of candidate by keyword(s)
     * @param keywords keywords that connected with candidate
     */
    List<Candidate> findPeopleByKeywords(Set<Keyword> keywords);

    /**
     * @return List of candidate by attribute(s)
     * @param attributes attributes that connected with candidate
     */
    List<Candidate> findPeopleByHumanAttributes(Set<CandidateAttributes> attributes);
}
