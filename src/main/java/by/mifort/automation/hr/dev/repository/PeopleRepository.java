package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, String> {
}
