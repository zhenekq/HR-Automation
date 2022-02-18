package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for working with Candidate in database
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see Candidate
 */

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {

    /**
     * @param pageable settings to pagination
     * @return Paginated information about people
     */
    @Query("select p from Candidate p")
    Page<Candidate> findAllCandidates(Pageable pageable);

    /**
     * @param pageable settings to pagination
     * @return Paginated information about people by keywords
     */
    @Query("select p from Candidate p inner join p.keywords kb where kb.id =:keyword")
    List<Candidate> findAllByKeywords(String keyword, Pageable pageable);
}
