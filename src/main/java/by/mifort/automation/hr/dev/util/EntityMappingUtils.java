package by.mifort.automation.hr.dev.util;

import by.mifort.automation.hr.dev.dto.PeopleDto;
import by.mifort.automation.hr.dev.entity.People;

import java.util.HashSet;

public class EntityMappingUtils {
    private static EntityMappingUtils instance = new EntityMappingUtils();

    private EntityMappingUtils(){}

    public static EntityMappingUtils getInstance() {
        if(instance == null){
            instance = new EntityMappingUtils();
        }
        return instance;
    }

    public static PeopleDto convertToPeopleDto(People people){
        PeopleDto peopleDto = new PeopleDto();
        peopleDto.setId(people.getId());
        peopleDto.setStatus(people.getStatus());
        peopleDto.setLastContact(people.getLastContact());
        peopleDto.setKeywords(people.getHumanKeywords());
        peopleDto.setCommunicationHistory(new HashSet<>());
        return peopleDto;
    }
}
