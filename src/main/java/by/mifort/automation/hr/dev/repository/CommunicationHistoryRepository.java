package by.mifort.automation.hr.dev.repository;

import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationHistoryRepository extends JpaRepository<CommunicationHistory, Integer> {
}
