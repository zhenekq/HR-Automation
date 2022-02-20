package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.service.CommunicationHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller that handles requests about candidate's history communication
 *
 * @author yauheni_vozny
 * @version 1.0
 */
@RestController
@RequestMapping("/candidates/{id}/history")
@Api("Controller for manipulate with history of candidate")
public class CandidateHistoryController {

    private final CommunicationHistoryService service;

    public CandidateHistoryController(CommunicationHistoryService service) {
        this.service = service;
    }

    /**
     * GET request to get candidate's history
     *
     * @param id - candidate identifier
     * @return CommunicationHistory of candidate
     */
    @ApiOperation("Get all histories with candidate by his id")
    @GetMapping
    public List<CommunicationHistoryDto> getByCandidateId(@PathVariable String id) {
        return service.getByCandidateId(id);
    }

    /**
     * POST request to create history with candidate
     *
     * @param id      candidate identifier
     * @param history body of history
     * @return Candidate's id
     */
    @ApiOperation("Create new history with candidate by his id")
    @PostMapping
    public String createByCandidateId(@PathVariable String id,
                                      @RequestBody CommunicationHistory history) {
        service.createByCandidateId(id, history);
        return id;
    }

    /**
     * PATCH request to update history with candidate
     *
     * @param id      candidate identifier
     * @param history body of history
     * @return Candidate's id
     */
    @ApiOperation("Update history with candidate by his id")
    @PatchMapping
    public String updateByCandidateId(@PathVariable String id,
                                      @RequestBody CommunicationHistoryDto history) {
        service.updateByCandidateId(id, history);
        return id;
    }

    /**
     * DELETE request to archive history with candidate
     *
     * @param id candidate identifier
     * @return Candidate's id
     */
    @ApiOperation("Archive history with candidate with his id")
    @DeleteMapping
    public String archiveHistoryWithCandidate(@PathVariable String id) {
        service.archiveByCandidateId(id);
        return id;
    }
}
