package by.mifort.automation.hr.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleAttributesRepository extends JpaRepository<PeopleRepository, Integer> {
}
