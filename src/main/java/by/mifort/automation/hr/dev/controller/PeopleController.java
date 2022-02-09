package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.repository.PeopleRepository;
import by.mifort.automation.hr.dev.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<People> getAll(@RequestParam(required = false) Set<Keyword> keywords) {
        if (keywords.isEmpty()) {
            return peopleService.getAllPeople();
        }
        return peopleService.findPeopleByKeywords(keywords).stream().toList();
    }

    @GetMapping("/{uuid}")
    public People getHumanByUUID(@PathVariable String uuid) {
        return peopleService.getHumanById(uuid);
    }

    @PostMapping
    public void add(@RequestBody People people) {
        peopleService.addNewHuman(people);
    }

}
