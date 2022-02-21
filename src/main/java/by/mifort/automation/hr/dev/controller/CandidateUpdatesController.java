package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.CandidateUpdateDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that handles requests about candidates updates
 *
 * @author yauheni_vozny
 * @version 1.0
 */
@RestController
@RequestMapping("/candidates/{id}/updates")
@Api("Candidate updates controller for manipulating with it")
public class CandidateUpdatesController {

    @GetMapping
    public CandidateUpdateDto getByCandidateId(@PathVariable String id,
                                               @RequestBody CandidateUpdateDto dto) {
        return dto;
    }

}
