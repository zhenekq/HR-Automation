package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.repository.PeopleRepository;
import by.mifort.automation.hr.dev.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<People> getAll(){
        System.out.println(peopleService.getHumanById("637bef46-8b7a-41d5-a2b5-b3eeb114f5e4"));
        return peopleService.getAllPeople();
    }

    @GetMapping("/{uuid}")
    public People getHumanByUUID(@PathVariable String uuid){
        return peopleService.getHumanById(uuid);
    }

    @PostMapping
    public void add(@RequestBody People people){
        peopleService.addNewHuman(people);
    }

}
