package by.mifort.automation.hr.dev.util.impl;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.dto.KeywordDto;
import by.mifort.automation.hr.dev.dto.PeopleDto;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.util.MappingDtoComponentConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MappingDtoComponentConverterImpl implements MappingDtoComponentConverter {
    @Override
    public PeopleDto convertToPeopleDto(People people) {
        PeopleDto peopleDto = new PeopleDto();
        peopleDto.setId(people.getId());
        peopleDto.setStatus(people.getStatus());
        peopleDto.setLastContact(people.getLastContact());
        peopleDto.setKeywords(convertToListKeywordDto(people.getHumanKeywords()));
        peopleDto.setCommunicationHistory(people.getCommunicationHistory());
        return peopleDto;
    }

    @Override
    public List<PeopleDto> convertToListPeopleDto(List<People> people) {
        List<PeopleDto> peopleDtoList = new ArrayList<>();
        people.forEach((el) -> peopleDtoList.add(convertToPeopleDto(el)));
        return peopleDtoList;
    }

    @Override
    public KeywordDto convertToKeywordDto(Keyword keyword) {
        KeywordDto keywordDto = new KeywordDto();
        keywordDto.setId(keyword.getId());
        return keywordDto;
    }

    @Override
    public List<KeywordDto> convertToListKeywordDto(List<Keyword> keywords) {
        List<KeywordDto> list = new ArrayList<>();
        keywords.forEach((el) -> list.add(convertToKeywordDto(el)));
        return list;
    }

    @Override
    public CommunicationHistoryDto convertToCommunicationHistoryDto(CommunicationHistory communicationHistory) {
        return null;
    }

    @Override
    public List<CommunicationHistoryDto> convertToListCommunicationHistoryDto(List<CommunicationHistory> communicationHistoryList) {
        return null;
    }
}
