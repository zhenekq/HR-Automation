package by.mifort.automation.hr.dev.service.duplicates.strategies;

import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.repository.CandidateAttributesRepository;
import by.mifort.automation.hr.dev.service.duplicates.DuplicatesStrategy;
import by.mifort.automation.hr.dev.service.duplicates.DuplicatesStrategyName;
import by.mifort.automation.hr.dev.service.duplicates.comparator.SingleAttributeComparator;
import by.mifort.automation.hr.dev.service.duplicates.separate.SeparateService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KeyAttributeStrategy implements DuplicatesStrategy {

    private final CandidateAttributesRepository repository;
    private final SeparateService separateService;

    public KeyAttributeStrategy(CandidateAttributesRepository repository, SeparateService separateService) {
        this.repository = repository;
        this.separateService = separateService;
    }

    @Override
    public List<List<Candidate>> getDuplicates() {
        List<CandidateAttributes> email = repository.findCandidateAttributesByAttributeTypesName(DuplicatesStrategyName.EMAIL.name());
        List<CandidateAttributes> facebook_id = repository.findCandidateAttributesByAttributeTypesName(DuplicatesStrategyName.FACEBOOKID.name());
        List<CandidateAttributes> github_id = repository.findCandidateAttributesByAttributeTypesName(DuplicatesStrategyName.GITHUBID.name());
        List<CandidateAttributes> instagram = repository.findCandidateAttributesByAttributeTypesName(DuplicatesStrategyName.INSTAGRAM.name());
        List<CandidateAttributes> linkedin = repository.findCandidateAttributesByAttributeTypesName(DuplicatesStrategyName.LINKEDIN.name());
        List<CandidateAttributes> phone = repository.findCandidateAttributesByAttributeTypesName(DuplicatesStrategyName.PHONE.name());
        List<CandidateAttributes> telegram = repository.findCandidateAttributesByAttributeTypesName(DuplicatesStrategyName.TELEGRAM.name());

        return push(email, linkedin, facebook_id, github_id, phone, telegram);
    }

    @Override
    public DuplicatesStrategyName getStrategyName() {
        return DuplicatesStrategyName.KEY_STRATEGY;
    }

    private List<List<Candidate>> push(List<CandidateAttributes>... attributes){
        List<List<Candidate>> result = new ArrayList<>();
        for(int i=0;i<attributes.length;i++){
            result.addAll(separateService.separateByOneAttribute(attributes[i], new SingleAttributeComparator()));
        }
        return result;
    }
}
