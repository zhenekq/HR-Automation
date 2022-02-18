package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.AttributeTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with candidate's attributes types in database
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see AttributeTypes
 */

@Repository
public interface AttributeTypesRepository extends JpaRepository<AttributeTypes, Integer> {
}
