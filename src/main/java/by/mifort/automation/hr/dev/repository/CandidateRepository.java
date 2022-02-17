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
 * @see Candidate
 * @author yauheni_vozny
 * @version 1.0
 */

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {

    /**
     * @return Paginated information about people
     * @param pageable settings to pagination
     */
    @Query("select p from Candidate p")
    Page<Candidate> findAllPeople(Pageable pageable);

    @Query("select p from Candidate p inner join p.candidateKeywords kb where kb.id =:keyword")
    List<Candidate> findAllByHumanKeywords(String keyword, Pageable pageable);
}
