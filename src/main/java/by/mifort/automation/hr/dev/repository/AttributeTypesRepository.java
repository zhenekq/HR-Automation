package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.AttributeTypes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for working with candidate's attributes types in database
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see AttributeTypes
 */

@Repository
public interface AttributeTypesRepository extends JpaRepository<AttributeTypes, Integer> {
    /**
     * @param pageable settings to pagination
     * @param archived is attribute archived
     * @return Paginated information about attribute types
     */
    List<AttributeTypes> findAllByIsArchivedEquals(Pageable pageable, Boolean archived);
}
