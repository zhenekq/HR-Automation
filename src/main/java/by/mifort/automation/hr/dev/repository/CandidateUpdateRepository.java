package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.CandidateUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with candidate's CandidateUpdate in database
 * @see CandidateUpdate
 * @author yauheni_vozny
 * @version 1.0
 */

@Repository
public interface CandidateUpdateRepository extends JpaRepository<CandidateUpdate, Integer> {
}
