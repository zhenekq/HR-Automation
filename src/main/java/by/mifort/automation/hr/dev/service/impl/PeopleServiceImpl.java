package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.repository.PeopleRepository;
import by.mifort.automation.hr.dev.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public List<People> getAllPeople() {
        return peopleRepository.findAll();
    }

    @Override
    public People getHumanById(String uuid) {
        return peopleRepository.findById(uuid).get();
    }

    @Override
    public void addNewHuman(People people) {
        peopleRepository.save(people);
    }
}
