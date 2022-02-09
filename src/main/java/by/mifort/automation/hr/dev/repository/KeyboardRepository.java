package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<Keyword, String> {
}
