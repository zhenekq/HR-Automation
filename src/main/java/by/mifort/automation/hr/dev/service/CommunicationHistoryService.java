package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.dto.FilterDto;

import java.util.List;

/**
 * Service layer for validation and business logic CommunicationHistoryRepository
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see by.mifort.automation.hr.dev.repository.CommunicationHistoryRepository
 */


public interface CommunicationHistoryService {

    /**
     * Get history of candidate by id
     *
     * @param candidateId candidate's identifier
     */
    List<CommunicationHistoryDto> getByCandidateId(String candidateId, FilterDto filterDto);

    /**
     * Create new communication history with candidate
     *
     * @param candidateId candidate's identifier
     * @param historyDto  body of history
     */
    CommunicationHistoryDto createByCandidateId(String candidateId, CommunicationHistoryDto historyDto);

    /**
     * Update exists communication history with candidate
     *
     * @param candidateId candidate's identifier
     * @param historyDto     body of history
     */
    CommunicationHistoryDto updateByCandidateId(String candidateId, CommunicationHistoryDto historyDto);

    /**
     * Archive exists communication history with candidate
     *
     * @param candidateId candidate's identifier
     * @param historyId   history's identifier
     */
    CommunicationHistoryDto archiveByCandidateId(String candidateId, Integer historyId);
}
