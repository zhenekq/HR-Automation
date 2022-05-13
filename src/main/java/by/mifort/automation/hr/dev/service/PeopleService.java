package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.dto.PeopleDto;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.entity.PeopleAttributes;

import java.util.List;
import java.util.Set;

/**
 * Service layer for validation and business logic for PeopleRepository
 * @see by.mifort.automation.hr.dev.repository.PeopleRepository
 * @author yauheni_vozny
 * @version 1.0
 */

public interface PeopleService {

    /**
     * @return List of all exists paginated candidates
     * @param page number of page to see candidates
     */
    List<PeopleDto> getAllPeople(Integer page);

    /**
     * @return information about candidate
     * @param id identifier of candidate
     */
    PeopleDto getHumanById(String id);

    /**
     * Create new candidate in database
     * @param people body of our candidate
     */
    void addNewHuman(People people);

    /**
     * @return List of candidate by keyword(s)
     * @param keywords keywords that connected with candidate
     */
    List<People> findPeopleByKeywords(Set<Keyword> keywords);

    /**
     * @return List of candidate by attribute(s)
     * @param attributes attributes that connected with candidate
     */
    List<People> findPeopleByHumanAttributes(Set<PeopleAttributes> attributes);
}
