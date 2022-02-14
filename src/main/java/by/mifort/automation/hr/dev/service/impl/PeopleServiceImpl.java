package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.PeopleDto;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.entity.PeopleAttributes;
import by.mifort.automation.hr.dev.repository.PeopleRepository;
import by.mifort.automation.hr.dev.service.PeopleService;
import by.mifort.automation.hr.dev.util.EntityMappingUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;
    private final Integer AMOUNT_OF_RESULTS_ON_ONE_PAGE = 2;

    @Autowired
    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public List<PeopleDto> getAllPeople(Integer page) {
        List<People> peopleList = new ArrayList<>();
        if(page == null){
            peopleList = peopleRepository.findAll();
            return EntityMappingUtils.convertToListPeopleDto(peopleList);
        }
        Pageable pageable = PageRequest.of(page - 1, AMOUNT_OF_RESULTS_ON_ONE_PAGE);
        peopleList = peopleRepository.findAllPeople(pageable).toList();
        return EntityMappingUtils.convertToListPeopleDto(peopleList);
    }

    @Override
    public PeopleDto getHumanById(@NotNull String id) {
        People people = peopleRepository.getById(id);
        return EntityMappingUtils.convertToPeopleDto(people);
    }

    @Override
    @Transactional
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
