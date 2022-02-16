package by.mifort.automation.hr.dev.util;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.dto.KeywordDto;
import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.Candidate;

import java.util.List;

/**
 * Dto converter to entities
 * @author yauheni_vozny
 * @version 1.0
 * */

public interface MappingDtoComponentConverter {

    CandidateDto convertToPeopleDto(Candidate candidate);

    List<CandidateDto> convertToListPeopleDto(List<Candidate> people);

    KeywordDto convertToKeywordDto(Keyword keyword);

    List<KeywordDto> convertToListKeywordDto(List<Keyword> keywords);

    CommunicationHistoryDto convertToCommunicationHistoryDto(CommunicationHistory communicationHistory);

    List<CommunicationHistoryDto> convertToListCommunicationHistoryDto(List<CommunicationHistory> communicationHistoryList);



}
