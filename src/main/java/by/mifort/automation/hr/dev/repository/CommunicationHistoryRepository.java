package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for working with candidate's CommunicationHistory in database
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see CommunicationHistory
 */

@Repository
public interface CommunicationHistoryRepository extends JpaRepository<CommunicationHistory, Integer> {
    /**
     * @param id human id for find his communication history
     * @return page of not archived communication history with candidate
     */
    List<CommunicationHistory> findCommunicationHistoriesByCandidateIdAndIsArchivedFalse(String id);

    /**
     * @param id human id for find his communication history
     * @return page of archived communication history with candidate
     */
    List<CommunicationHistory> findCommunicationHistoriesByCandidateIdAndIsArchivedTrue(String id);

    /**
     * @param candidateId candidate id for find his communication history
     * @param id          history id for find it history
     * @return history that connected with candidate by both identifiers
     */
    Optional<CommunicationHistory> findCommunicationHistoryByCandidateIdAndId(String candidateId, Integer id);
}
