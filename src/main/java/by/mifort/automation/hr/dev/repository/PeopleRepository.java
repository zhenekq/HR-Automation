package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.entity.PeopleAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface PeopleRepository extends JpaRepository<People, String> {
    Set<People> findPeopleByHumanKeywords(Set<Keyword> keywords);
    Set<People> findPeopleByHumanAttributes(Set<PeopleAttributes> attributes);
}
