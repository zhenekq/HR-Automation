package by.mifort.automation.hr.dev.controller;

import org.springframework.stereotype.Component;

@Component
public class HeadTestConfiguration {

    private final CandidateController candidateController;

    public HeadTestConfiguration(CandidateController candidateController) {
        this.candidateController = candidateController;
    }

    public CandidateController getCandidateController() {
        return candidateController;
    }
}
