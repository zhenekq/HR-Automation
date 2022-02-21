package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.dto.AttributeTypesDto;
import by.mifort.automation.hr.dev.dto.FilterDto;

import java.util.List;

/**
 * Service layer for validation and business logic for AttributeTypesRepository
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see by.mifort.automation.hr.dev.repository.AttributeTypesRepository
 */

public interface AttributeTypesService {

    /**
     * @param filterDto dto with pagination, sortTypes
     * @return List of all exists paginated attribute types
     * @see FilterDto
     */
    List<AttributeTypesDto> getAll(FilterDto filterDto);

    /**
     * Create new attribute type in database
     *
     * @param dto body of our attribute type
     */
    AttributeTypesDto create(AttributeTypesDto dto);

    /**
     * Update exists attribute type
     *
     * @param id  attribute's type identifier
     * @param dto body of attribute's type
     */
    AttributeTypesDto updateById(Integer id, AttributeTypesDto dto);

    /**
     * Archive exists attribute's type
     *
     * @param id attribute's type identifier
     */
    AttributeTypesDto archiveById(Integer id);

}
