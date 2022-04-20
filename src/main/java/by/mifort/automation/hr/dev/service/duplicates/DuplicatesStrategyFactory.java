package by.mifort.automation.hr.dev.service.duplicates;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Factory for putting ways finding duplicates and their identifiers
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see by.mifort.automation.hr.dev.repository.AttributeTypesRepository
 */
@Component
public class DuplicatesStrategyFactory {

    private Map<DuplicatesStrategyName, DuplicatesStrategy> duplicatesStrategies;

    public DuplicatesStrategyFactory(Set<DuplicatesStrategy> duplicatesStrategies){
        fillStrategies(duplicatesStrategies);
    }

    public DuplicatesStrategy findStrategy(DuplicatesStrategyName strategyName){
        return duplicatesStrategies.get(strategyName);
    }

    private void fillStrategies(Set<DuplicatesStrategy> strategies){
        duplicatesStrategies = new HashMap<>();
        strategies.forEach(
                strategy -> duplicatesStrategies.put(strategy.getStrategyName(), strategy)
        );
    }

}
