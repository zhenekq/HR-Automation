package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.entity.CandidateAttributes;

import java.util.List;

/**
 * Service layer for validation and business logic for CandidateAttributesRepository
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see by.mifort.automation.hr.dev.repository.CandidateAttributesRepository
 */

public interface CandidateAttributesService {

    /**
     * Get attributes of candidate by id
     *
     * @param candidateId candidate's identifier
     */
    List<CandidateAttributes> getByCandidateId(String candidateId);

    /**
     * Create new attributes with candidate
     *
     * @param candidateId     candidate's identifier
     * @param attributes      body of attributes
     * @param attributeTypeId attribute type identifier
     */
    CandidateAttributes createByCandidateIdAndAttributeTypeId(String candidateId, Integer attributeTypeId, CandidateAttributes attributes);
}
