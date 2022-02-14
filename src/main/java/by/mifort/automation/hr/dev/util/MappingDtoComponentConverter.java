package by.mifort.automation.hr.dev.util;

import by.mifort.automation.hr.dev.dto.KeywordDto;
import by.mifort.automation.hr.dev.dto.PeopleDto;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;

import java.util.List;
import java.util.Set;

public interface MappingDtoComponentConverter {

    PeopleDto convertToPeopleDto(People people);

    List<PeopleDto> convertToListPeopleDto(List<People> people);

    KeywordDto convertToKeywordDto(Keyword keyword);

    Set<KeywordDto> convertToListKeywordDto(Set<Keyword> keywords);


}
