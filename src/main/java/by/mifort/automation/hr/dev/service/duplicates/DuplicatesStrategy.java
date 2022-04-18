package by.mifort.automation.hr.dev.service.duplicates;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;

import java.util.List;

/**
 * Strategy pattern interface for different ways to find duplicates between candidates
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see DuplicatesStrategyFactory
 */
public interface DuplicatesStrategy {

    List<List<CandidateAttributes>> getDuplicates();

    DuplicatesStrategyName getStrategyName();
}