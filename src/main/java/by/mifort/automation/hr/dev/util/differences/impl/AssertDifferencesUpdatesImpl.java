package by.mifort.automation.hr.dev.util.differences.impl;

import by.mifort.automation.hr.dev.dto.AttributeTypesDto;
import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.entity.AttributeTypes;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.util.differences.AssertDifferencesUpdates;
import org.springframework.stereotype.Component;

@Component
public class AssertDifferencesUpdatesImpl implements AssertDifferencesUpdates {
    @Override
    public CommunicationHistory assertCommunicationHistoryAndDto(CommunicationHistory history, CommunicationHistoryDto historyDto) {
        if (historyDto.getComment() != null) {
            history.setComment(historyDto.getComment());
        }
        if (historyDto.getCreateDate() != null) {
            history.setCreateDate(historyDto.getCreateDate());
        }
        if (historyDto.getUpdateDate() != null) {
            history.setUpdateDate(historyDto.getUpdateDate());
        }
        return history;
    }

    @Override
    public AttributeTypes assertAttributeTypesAndDto(AttributeTypes types, AttributeTypesDto dto) {
        if (dto.getIdentifier() != null) {
            types.setIdentifier(dto.getIdentifier());
        }
        if (dto.getBasicType() != null) {
            types.setBasicType(dto.getBasicType());
        }
        if (dto.getName() != null) {
            types.setName(dto.getName());
        }
        if (dto.getValidation() != null) {
            types.setValidation(dto.getValidation());
        }
        return types;
    }
}
