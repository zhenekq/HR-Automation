package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleRepository repository;

    @Autowired
    public PeopleController(PeopleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<People> getAll(){
        return repository.findAll();
    }

    @PostMapping
    public void add(@RequestBody People people){
        repository.save(people);
    }

}
