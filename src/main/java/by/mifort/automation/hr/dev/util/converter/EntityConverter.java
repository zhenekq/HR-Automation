package by.mifort.automation.hr.dev.util.converter;

import java.util.List;

/**
 * Dto converter to entities
 *
 * @author yauheni_vozny
 * @version 1.0
 */

public interface EntityConverter<Entity, EntityDto> {

    EntityDto convertToEntityDto(Entity entity);

    List<EntityDto> convertToListEntityDto(List<Entity> entities);

    Entity convertToEntity(EntityDto entityDto);

    List<Entity> convertToListEntity(List<EntityDto> entityDtoList);

    /*CommunicationHistoryDto convertToCommunicationHistoryDto(CommunicationHistory communicationHistory);

    List<CommunicationHistoryDto> convertToListCommunicationHistoryDto(List<CommunicationHistory> communicationHistoryList);

    CommunicationHistory convertToCommunicationHistory(CommunicationHistoryDto dto);

    CandidateAttributesDto convertToCandidateAttributesDto(CandidateAttributes attributes);

    List<CandidateAttributesDto> convertToListCandidateAttributesDto(List<CandidateAttributes> attributes);

    AttributeTypesDto convertToAttributeTypeDto(AttributeTypes attributeTypes);

    List<AttributeTypesDto> convertToListAttributeTypesDto(List<AttributeTypes> attributeTypes);*/
}
