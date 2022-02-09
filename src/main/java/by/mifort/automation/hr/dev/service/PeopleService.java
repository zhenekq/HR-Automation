package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.entity.PeopleAttributes;

import java.util.List;
import java.util.Set;

public interface PeopleService {

    List<People> getAllPeople();
    People getHumanById(String uuid);
    void addNewHuman(People people);
    Set<People> findPeopleByKeywords(Set<Keyword> keywords);
    Set<People> findPeopleByHumanAttributes(Set<PeopleAttributes> attributes);
}
