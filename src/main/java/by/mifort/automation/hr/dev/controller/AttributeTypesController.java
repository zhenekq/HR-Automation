package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.AttributeTypesDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.service.AttributeTypesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controller that handles requests about attribute types
 *
 * @author yauheni_vozny
 * @version 1.0
 */

@RestController
@RequestMapping("/candidates/attributes")
@Api("Controller for manipulate with attribute types")
public class AttributeTypesController {

    private final AttributeTypesService service;

    @Autowired
    public AttributeTypesController(AttributeTypesService service) {
        this.service = service;
    }

    /**
     * GET request to get attribute types
     *
     * @return List of attribute types
     */
    @ApiOperation("Get paginated attribute types")
    @GetMapping
    public List<AttributeTypesDto> getAll(FilterDto filterDto) {
        Integer pageNumber = filterDto.getPageNumber();
        Integer pageSize = filterDto.getPageSize();
        if (pageNumber == null || pageSize == null || pageNumber <= 0 || pageSize <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parameters cannot be nullable");
        }
        return service.getAll(filterDto);
    }

    /**
     * POST request to create new attribute type
     *
     * @param type attribute type body
     * @return created attribute type
     */
    @ApiOperation("Create new attribute type")
    @PostMapping
    public AttributeTypesDto create(@RequestBody AttributeTypesDto type) {
        return service.create(type);
    }

    /**
     * PATCH request to update attribute type
     *
     * @param id attribute type identifier
     * @return updated attribute type
     */
    @ApiOperation("Update attribute type")
    @PatchMapping("{id}")
    public AttributeTypesDto updateByAttributeId(@PathVariable Integer id,
                                                 @RequestBody AttributeTypesDto type) {
        return service.updateById(id, type);
    }

    /**
     * DELETE request to archive attribute type
     *
     * @param id attribute type identifier
     * @return attribute type
     */
    @ApiOperation("Archive attribute type")
    @DeleteMapping("{id}")
    public AttributeTypesDto deleteByAttributeId(@PathVariable Integer id) {
        return service.archiveById(id);
    }
}
