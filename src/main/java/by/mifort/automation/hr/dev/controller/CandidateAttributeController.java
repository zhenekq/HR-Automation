package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.CandidateAttributesDto;
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
    public List<CandidateAttributesDto> getByCandidateId(@PathVariable String id) {
        return service.getByCandidateId(id);
    }

    /**
     * POST request to create attributes with candidate
     *
     * @param id         candidate identifier
     * @param attributes body of attributes
     * @param type       attribute type
     * @return Candidate's id
     */
    @ApiOperation("Create new attributes with candidate by his id")
    @PostMapping
    public String createByCandidateId(@PathVariable String id,
                                      @RequestBody CandidateAttributes attributes,
                                      @RequestParam Integer type) {
        service.createByCandidateIdAndAttributeTypeId(id, type, attributes);
        return id;
    }
}
