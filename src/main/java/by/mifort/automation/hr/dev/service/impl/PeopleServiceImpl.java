package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.entity.PeopleAttributes;
import by.mifort.automation.hr.dev.repository.PeopleRepository;
import by.mifort.automation.hr.dev.service.PeopleService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public People getHumanById(@NotNull String id) {
        return peopleRepository.getById(id);
    }

    @Override
    public void addNewHuman(@NotNull People people) {
        peopleRepository.save(people);
    }

    @Override
    public List<People> findPeopleByKeywords(@NotNull Set<Keyword> keywords) {
        return new ArrayList<>();
    }

    @Override
    public List<People> findPeopleByHumanAttributes(@NotNull Set<PeopleAttributes> attributes) {
        return new ArrayList<>();
    }
}
