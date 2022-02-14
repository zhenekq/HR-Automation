package by.mifort.automation.hr.dev.util;

import by.mifort.automation.hr.dev.dto.KeywordDto;
import by.mifort.automation.hr.dev.dto.PeopleDto;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Singleton util class for mapping from Entity to EntityDto
 * @author yauheni_vozny
 * @version 1.0
 * */

public class EntityMappingUtils {
    private static EntityMappingUtils instance = new EntityMappingUtils();

    private EntityMappingUtils(){}

    public static EntityMappingUtils getInstance() {
        if(instance == null){
            instance = new EntityMappingUtils();
        }
        return instance;
    }

    public static List<PeopleDto> convertToListPeopleDto(List<People> people){
        List<PeopleDto> peopleDtoList = new ArrayList<>();
        people.forEach((el) -> peopleDtoList.add(convertToPeopleDto(el)));
        return peopleDtoList;
    }

    public static PeopleDto convertToPeopleDto(People people){
        PeopleDto peopleDto = new PeopleDto();
        peopleDto.setId(people.getId());
        peopleDto.setStatus(people.getStatus());
        peopleDto.setLastContact(people.getLastContact());
        peopleDto.setKeywords(convertToListKeywordDto(people.getHumanKeywords()));
        peopleDto.setCommunicationHistory(people.getCommunicationHistory());
        return peopleDto;
    }

    public static KeywordDto convertToKeywordDto(Keyword keyword){
        KeywordDto keywordDto = new KeywordDto();
        keywordDto.setId(keyword.getId());
        return keywordDto;
    }

    public static Set<KeywordDto> convertToListKeywordDto(Set<Keyword> keywords){
        Set<KeywordDto> list = new HashSet<>();
        keywords.forEach((el) -> list.add(convertToKeywordDto(el)));
        return list;
    }
}
