package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.entity.People;

import java.util.List;

public interface PeopleService {

    List<People> getAllPeople();
    People getHumanById(String uuid);
    void addNewHuman(People people);
}
