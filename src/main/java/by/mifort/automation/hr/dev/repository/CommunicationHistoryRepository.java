package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for working with candidate's CommunicationHistory in database
 * @see CommunicationHistory
 * @author yauheni_vozny
 * @version 1.0
 */

@Repository
public interface CommunicationHistoryRepository extends JpaRepository<CommunicationHistory, Integer> {

    /**
     * @param pageable value for pagination
     * @return page of communication history with all candidates
     * */

    Page<CommunicationHistory> findAllHistory(Pageable pageable);

    /**
     * @param id human id for find his communication history
     * @return page of communication history with candidate
     * */
    List<CommunicationHistory> findCommunicationHistoriesByCandidateId(String id);

    Boolean existsCommunicationHistoryByCandidateId(String id);

}
