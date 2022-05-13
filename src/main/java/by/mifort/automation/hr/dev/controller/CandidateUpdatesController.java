package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.CandidateUpdateDto;
import by.mifort.automation.hr.dev.entity.CandidateUpdate;
import by.mifort.automation.hr.dev.service.CandidateUpdatesService;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    private final CandidateUpdatesService service;
    private final EntityConverter<CandidateUpdate, CandidateUpdateDto> converter;

    @Autowired
    public CandidateUpdatesController(CandidateUpdatesService service, EntityConverter<CandidateUpdate, CandidateUpdateDto> converter) {
        this.service = service;
        this.converter = converter;
    }

    /**
     * GET request to receive all info about candidate's updates
     *
     * @param id candidate's identifier
     * @return Full list of candidate's updates
     */

    @GetMapping
    public List<CandidateUpdateDto> getByCandidateId(@PathVariable String id) {
        List<CandidateUpdate> updates = service.getByCandidateId(id);
        return converter.convertToListEntityDto(updates);
    }

}
