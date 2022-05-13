package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.AttributeTypes;
import by.mifort.automation.hr.dev.entity.PeopleAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with it in database
 * @see PeopleAttributes
 * @author yauheni_vozny
 * @version 1.0
 */

@Repository
public interface PeopleAttributesRepository extends JpaRepository<PeopleAttributes, Integer> {
}
