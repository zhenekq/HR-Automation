package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.PeopleAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleAttributesRepository extends JpaRepository<PeopleAttributes, Integer> {
}
