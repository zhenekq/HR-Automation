package by.mifort.automation.hr.dev.util;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.dto.KeywordDto;
import by.mifort.automation.hr.dev.dto.PeopleDto;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;

import java.util.List;
import java.util.Set;

/**
 * Dto converter to entities
 * @author yauheni_vozny
 * @version 1.0
 * */

public interface MappingDtoComponentConverter {

    PeopleDto convertToPeopleDto(People people);

    List<PeopleDto> convertToListPeopleDto(List<People> people);

    KeywordDto convertToKeywordDto(Keyword keyword);

    List<KeywordDto> convertToListKeywordDto(List<Keyword> keywords);

    CommunicationHistoryDto convertToCommunicationHistoryDto(CommunicationHistory communicationHistory);

    List<CommunicationHistoryDto> convertToListCommunicationHistoryDto(List<CommunicationHistory> communicationHistoryList);



}
