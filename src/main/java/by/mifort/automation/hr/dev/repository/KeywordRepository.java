package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with it in database
 * @see Keyword
 * @author yauheni_vozny
 * @version 1.0
 */

@Repository
public interface KeyboardRepository extends JpaRepository<Keyword, String> {
}
