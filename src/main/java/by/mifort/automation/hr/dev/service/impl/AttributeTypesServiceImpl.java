package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.AttributeTypesDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.AttributeTypes;
import by.mifort.automation.hr.dev.repository.AttributeTypesRepository;
import by.mifort.automation.hr.dev.service.AttributeTypesService;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
import by.mifort.automation.hr.dev.util.differences.AssertDifferencesUpdates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AttributeTypesServiceImpl implements AttributeTypesService {

    private final AttributeTypesRepository repository;
    private final EntityConverter<AttributeTypes, AttributeTypesDto> converter;
    private final AssertDifferencesUpdates assertDifferencesUpdates;

    @Autowired
    public AttributeTypesServiceImpl(AttributeTypesRepository repository, EntityConverter<AttributeTypes, AttributeTypesDto> converter, AssertDifferencesUpdates assertDifferencesUpdates) {
        this.repository = repository;
        this.converter = converter;
        this.assertDifferencesUpdates = assertDifferencesUpdates;
    }

    @Override
    public List<AttributeTypesDto> getAll(FilterDto filterDto) {
        List<AttributeTypes> types;
        Integer page = filterDto.getPageNumber();
        Integer amount = filterDto.getPageSize();
        Pageable pageable = PageRequest.of(page - 1, amount);
        if (filterDto.getIsArchived() == null || !filterDto.getIsArchived()) {
            types = repository
                    .findAllByIsArchivedEquals(pageable, Boolean.FALSE);
            return converter.convertToListEntityDto(types);
        }
        types = repository.findAllByIsArchivedEquals(pageable, Boolean.TRUE);
        return converter.convertToListEntityDto(types);
    }

    @Override
    public AttributeTypesDto create(AttributeTypesDto dto) {
        AttributeTypes types = converter.convertToEntity(dto);
        repository.save(types);
        return dto;
    }

    @Override
    public AttributeTypesDto updateById(Integer id, AttributeTypesDto dto) {
        AttributeTypes attributeTypes = repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        attributeTypes = assertDifferencesUpdates.assertAttributeTypesAndDto(attributeTypes, dto);
        repository.save(attributeTypes);
        return converter.convertToEntityDto(attributeTypes);

    }

    @Override
    public AttributeTypesDto archiveById(Integer id) {
        AttributeTypes attributeTypes = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Attribute type do not exists"));
        attributeTypes.setArchived(Boolean.TRUE);
        repository.save(attributeTypes);
        return converter.convertToEntityDto(attributeTypes);
    }
}
