package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.service.CandidateAttributesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller that handles requests about candidate's attributes
 *
 * @author yauheni_vozny
 * @version 1.0
 */

@RestController
@RequestMapping("/candidates/{id}/attributes")
@Api("Controller for manipulate with attributes of candidate")
public class CandidateAttributeController {

    private final CandidateAttributesService service;

    @Autowired
    public CandidateAttributeController(CandidateAttributesService service) {
        this.service = service;
    }

    /**
     * GET request to get candidate's attributes
     *
     * @param id candidate identifier
     * @return CandidateAttributes of candidate
     */
    @ApiOperation("Get attributes of candidate by his id")
    @GetMapping
    public List<CandidateAttributes> getByCandidateId(@PathVariable String id) {
        return null;
    }

    /**
     * POST request to create attributes with candidate
     *
     * @param id         candidate identifier
     * @param attributes body of attributes
     * @return Candidate's id
     */
    @ApiOperation("Create new attributes with candidate by his id")
    @PostMapping
    public String createByCandidateId(@PathVariable String id,
                                      @RequestBody CandidateAttributes attributes) {
        return id;
    }

    /**
     * PATCH request to update attributes with candidate
     *
     * @param id candidate identifier
     * @param attributes body of attribute
     * @return Candidate's id
     */
    @ApiOperation("Update history with candidate by his id")
    @PatchMapping
    public String updateByCandidateId(@PathVariable String id,
                                      @RequestBody CandidateAttributes attributes) {
        return id;
    }

    /**
     * DELETE request to archive candidate's attributes
     *
     * @param id candidate identifier
     * @return Candidate's id
     */
    @ApiOperation("Archive history with candidate with his id")
    @DeleteMapping
    public String deleteByCandidateId(@PathVariable String id) {
        return id;
    }
}
