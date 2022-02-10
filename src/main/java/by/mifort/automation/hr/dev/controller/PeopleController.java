package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.entity.PeopleAttributes;
import by.mifort.automation.hr.dev.service.PeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

/**
 * Controller that handles requests about candidates
 * @author yauheni_vozny
 * @version 1.0
 */

@RestController
@RequestMapping("/candidates")
@Api("Candidate controller for searching and creating new")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    /**
     * GET request to receive all info about candidates
     * Also with filters such as keywords and attributes
     * @param page number of page of candidates
     * @return Full list of candidates or by keyboards or attributes
     */
    @ApiOperation("Get all users by page, on every page 20 users")
    @GetMapping
    public List<People> getAll(@RequestParam(required = false) Long page) {
        return peopleService.getAllPeople();
    }

    /**
     * GET request to receive info about candidate by id
     * @param id - unique identifier for searching
     * @return Candidate info by id
     */
    @ApiOperation("Get full information about user by id")
    @GetMapping("/{id}")
    public People getHumanById(@PathVariable String id) {
        return peopleService.getHumanById(id);
    }

    /**
     * POST request to create candidate
     * @param people - candidate entity body
     */
    @ApiOperation("Create new user")
    @PostMapping("/add")
    public String add(@RequestBody People people) {
        peopleService.addNewHuman(people);
        return people.getId();
    }

}
