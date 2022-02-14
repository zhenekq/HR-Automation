package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.KeywordDto;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.People;
import by.mifort.automation.hr.dev.repository.KeywordRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.List;

/**
 * Controller for manipulation with keywords connected with candidates
 * @author yauheni_vozny
 * @version 1.0
 */

@RestController
@RequestMapping("/candidates/keywords")
@Api("Controller for manipulation with keywords connected with candidates")
public class PeopleKeywordsController {

    private final KeywordRepository repository;

    public PeopleKeywordsController(KeywordRepository repository) {
        this.repository = repository;
    }

    @ApiOperation("Get all exists keywords")
    @GetMapping
    public List<Keyword> getAllKeywords(){
        List<Keyword> keywords = repository.findAll();
        return keywords;
    }

    @ApiOperation("Get users by certain keyword")
    @GetMapping("/{keyword}")
    public List<People> getUsersByKeyword(@PathVariable String keyword){
        return null;
    }

    @ApiOperation("Create new keyword, that you can connect with candidate")
    @PostMapping("/create")
    public String createKeyword(@RequestBody Keyword keyword){
        return "Keyword: " + keyword.getId() + " created to user: " + keyword.getHuman().getId();
    }

}
