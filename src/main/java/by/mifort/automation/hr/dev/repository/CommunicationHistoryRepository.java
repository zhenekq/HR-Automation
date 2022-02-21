package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
     * @param pageable value for pagination
     * @return page of communication history with all candidates
     */
    @Query("select h from CommunicationHistory h")
    Page<CommunicationHistory> findAllHistory(Pageable pageable);

    /**
     * @param id human id for find his communication history
     * @return page of communication history with candidate
     */
    List<CommunicationHistory> findCommunicationHistoriesByCandidateId(String id);

    /**
     * @param candidateId candidate id for find his communication history
     * @param id          history id for find it history
     * @return history that connected with candidate by both identifiers
     */
    Optional<CommunicationHistory> findCommunicationHistoryByCandidateIdAndId(String candidateId, Integer id);

}
