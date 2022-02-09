package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.PeopleUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleUpdateRepository extends JpaRepository<PeopleUpdate, Integer> {
}
