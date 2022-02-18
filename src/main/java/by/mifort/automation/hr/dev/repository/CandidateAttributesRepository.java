package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for working with candidate's Attributes in database
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see CandidateAttributes
 */

@Repository
public interface CandidateAttributesRepository extends JpaRepository<CandidateAttributes, Integer> {

    List<CandidateAttributes> findCandidateAttributesByCandidateId(String id);

}
