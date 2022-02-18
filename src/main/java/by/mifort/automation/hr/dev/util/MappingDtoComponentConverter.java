package by.mifort.automation.hr.dev.util;

import by.mifort.automation.hr.dev.dto.CandidateAttributesDto;
import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;

import java.util.List;

/**
 * Dto converter to entities
 *
 * @author yauheni_vozny
 * @version 1.0
 */

public interface MappingDtoComponentConverter {

    CandidateDto convertToPeopleDto(Candidate candidate);

    List<CandidateDto> convertToListPeopleDto(List<Candidate> people);

    CommunicationHistoryDto convertToCommunicationHistoryDto(CommunicationHistory communicationHistory);

    List<CommunicationHistoryDto> convertToListCommunicationHistoryDto(List<CommunicationHistory> communicationHistoryList);

    CandidateAttributesDto convertToCandidateAttributesDto(CandidateAttributes attributes);

    List<CandidateAttributesDto> convertToListCandidateAttributesDto(List<CandidateAttributes> attributes);
}
