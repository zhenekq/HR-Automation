package by.mifort.automation.hr.dev.util.validator.impl;

import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.util.validator.EntityValidator;
import org.springframework.stereotype.Component;

@Component
public class CandidateAttributeValidator implements EntityValidator<CandidateAttributes> {
    @Override
    public boolean isValidParams(CandidateAttributes attributes) {
        return  attributes.getValue() != null &&
                attributes.getValueSource() != null;
    }
}
