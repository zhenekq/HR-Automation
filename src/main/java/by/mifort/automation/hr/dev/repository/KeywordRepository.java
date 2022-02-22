package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.Keyword;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with candidate's Keywords in database
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see Keyword
 */

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, String> {

    /**
     * @param pageable settings to pagination
     * @return Paginated information about keywords
     */
    @Query("select k from Keyword k")
    Page<Keyword> findAllKeywords(Pageable pageable);
}
