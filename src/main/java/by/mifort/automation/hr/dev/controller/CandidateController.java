package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.service.CandidateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller that handles requests about candidates
 *
 * @author yauheni_vozny
 * @version 1.0
 */

@RestController
@RequestMapping("/candidates")
@Api("Candidate controller for searching and creating new")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    /**
     * GET request to receive all info about candidates
     * Also with filters such as keywords and attributes
     *
     * @param filterDto entity with pageSize, pageNum, and other filter configuration
     * @return Full list of candidates or by keyboards or not
     * @see FilterDto
     */
    @ApiOperation("Get paginated candidates, with amount of them on one page")
    @GetMapping
    public List<CandidateDto> getAll(FilterDto filterDto) {
        return candidateService.getAll(filterDto);
    }

    /**
     * GET request to receive info about candidate by id
     *
     * @param id unique identifier for searching
     * @return Candidate info by id
     */
    @ApiOperation("Get full information about user by id")
    @GetMapping("/{id}")
    public CandidateDto getById(@PathVariable String id) {
        return candidateService.getById(id);
    }

    /**
     * POST request to create candidate
     *
     * @param candidate candidate entity body
     * @return Conversation of successful created candidate with id
     */
    @ApiOperation("Create new candidate")
    @PostMapping
    public String create(@RequestBody CandidateDto candidate) {
        candidateService.create(candidate);
        return candidate.getId();
    }
}
