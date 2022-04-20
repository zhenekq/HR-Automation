package by.mifort.automation.hr.dev.service.duplicates.strategies;

import by.mifort.automation.hr.dev.dto.CandidateAttributesDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.repository.CandidateAttributesRepository;
import by.mifort.automation.hr.dev.service.duplicates.DuplicatesStrategy;
import by.mifort.automation.hr.dev.service.duplicates.DuplicatesStrategyName;
import by.mifort.automation.hr.dev.service.duplicates.DuplicatesStrategyUtils;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Way to find duplicates by value of candidate's Telegram
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see DuplicatesStrategy
 */
@Component
public class TelegramStrategy implements DuplicatesStrategy {
    private final EntityConverter<CandidateAttributes, CandidateAttributesDto> converter;
    private final CandidateAttributesRepository attributesRepository;

    public TelegramStrategy(EntityConverter<CandidateAttributes, CandidateAttributesDto> converter, CandidateAttributesRepository attributesRepository) {
        this.converter = converter;
        this.attributesRepository = attributesRepository;
    }

    @Override
    public List<List<Candidate>> getDuplicates() {
        List<CandidateAttributes> instagramCandidates = attributesRepository
                .findCandidateAttributesByAttributeTypesName(getStrategyName().name());
        return DuplicatesStrategyUtils.separate(instagramCandidates);
    }

    @Override
    public DuplicatesStrategyName getStrategyName() {
        return DuplicatesStrategyName.TELEGRAM;
    }
}
