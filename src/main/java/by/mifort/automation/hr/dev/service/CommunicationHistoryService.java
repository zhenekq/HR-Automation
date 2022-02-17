package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;

import java.util.List;

/**
 * Service layer for validation and business logic CommunicationHistoryRepository
 * @see by.mifort.automation.hr.dev.repository.CommunicationHistoryRepository
 * @author yauheni_vozny
 * @version 1.0
 * */


public interface CommunicationHistoryService {

    /**
     * Get history of candidate by id
     * @param id candidate's identifier
     */
    List<CommunicationHistoryDto> getByCandidateId(String id);

    /**
     * Create new communication history with candidate
     * @param id candidate's identifier
     * @param history body of history
     */
    CommunicationHistoryDto createByCandidateId(String id, CommunicationHistory history);

    /**
     * Update exists communication history with candidate
     * @param id candidate's identifier
     * @param history body of history
     */
    CommunicationHistoryDto updateByCandidateId(String id, CommunicationHistory history);

    /**
     * Archive exists communication history with candidate
     * @param id candidate's identifier
     * @param history body of history
     */
    CommunicationHistoryDto archiveByCandidateId(String id, CommunicationHistory history);
}
