package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.service.KeywordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private final KeywordService keywordService;

    @Autowired
    public PeopleKeywordsController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    /**
     * GET request to receive keywords connected with candidates
     * @param page number of page of keywords
     * @return Full list of keywords connected with candidates
     * */

    @ApiOperation("Get all exists keywords")
    @GetMapping
    public List<Keyword> getAllKeywords(@RequestParam(required = false) Integer page){
        return keywordService.getAllKeywords(page);
    }

    /**
     * GET request to receive keyword by id connected with candidate
     * @param keyword identifier of keyword
     * @return Keyword and connected candidates
     * */

    @ApiOperation("Get users by certain keyword")
    @GetMapping("/{keyword}")
    public List<Keyword> getUsersByKeyword(@PathVariable String keyword){
        return keywordService.getAllKeywordsById(keyword);
    }

    /**
     * POST request to create keyword and connect to candidate
     * @param keyword body of keyword in request
     * @return String of successful created keyword
     * */

    @ApiOperation("Create new keyword, that you can connect with candidate")
    @PostMapping("/create")
    public String createKeyword(@RequestBody Keyword keyword){
        return "Keyword: " + keyword.getId() + " created to user: " + keyword.getHuman().getId();
    }

}
