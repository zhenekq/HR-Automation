package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.AttributeTypes;
import by.mifort.automation.hr.dev.entity.PeopleUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with it in database
 * @see PeopleUpdate
 * @author yauheni_vozny
 * @version 1.0
 */

@Repository
public interface PeopleUpdateRepository extends JpaRepository<PeopleUpdate, Integer> {
}
