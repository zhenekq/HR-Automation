package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with candidate's Attributes in database
 * @see CandidateAttributes
 * @author yauheni_vozny
 * @version 1.0
 */

@Repository
public interface CandidateAttributesRepository extends JpaRepository<CandidateAttributes, Integer> {
}
