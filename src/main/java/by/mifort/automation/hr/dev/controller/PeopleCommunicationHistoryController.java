package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.service.CommunicationHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidates/history")
public class PeopleCommunicationHistoryController {

    private final CommunicationHistoryService service;

    public PeopleCommunicationHistoryController(CommunicationHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<CommunicationHistory> getLastCommunication(
            @RequestParam(required = false) Long page){
        return service.findByOrderByCreateDateDesc();
    }

}
