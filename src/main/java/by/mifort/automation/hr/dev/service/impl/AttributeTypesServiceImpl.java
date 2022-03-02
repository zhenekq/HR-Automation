package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.AttributeTypesDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.AttributeTypes;
import by.mifort.automation.hr.dev.repository.AttributeTypesRepository;
import by.mifort.automation.hr.dev.service.AttributeTypesService;
import by.mifort.automation.hr.dev.util.differences.AssertDifferencesUpdates;
import by.mifort.automation.hr.dev.util.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AttributeTypesServiceImpl implements AttributeTypesService {

    private final AttributeTypesRepository repository;
    private final AssertDifferencesUpdates assertDifferencesUpdates;
    private final EntityValidator<AttributeTypes> validator;

    @Autowired
    public AttributeTypesServiceImpl(AttributeTypesRepository repository, AssertDifferencesUpdates assertDifferencesUpdates, EntityValidator<AttributeTypes> validator) {
        this.repository = repository;
        this.assertDifferencesUpdates = assertDifferencesUpdates;
        this.validator = validator;
    }

    @Override
    public List<AttributeTypes> getAll(FilterDto filterDto) {
        List<AttributeTypes> types;
        Integer page = filterDto.getPageNumber();
        Integer amount = filterDto.getPageSize();
        Pageable pageable = PageRequest.of(page - 1, amount);
        if (filterDto.getIsArchived() == null || !filterDto.getIsArchived()) {
            types = repository
                    .findAllByIsArchivedEquals(pageable, Boolean.FALSE);
            return types;
        }
        types = repository.findAllByIsArchivedEquals(pageable, Boolean.TRUE);
        return types;
    }

    @Override
    public AttributeTypes getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Attribute type with id: " + id +" not found!"));
    }

    @Override
    public AttributeTypes create(AttributeTypes attributeTypes) {
        if(attributeTypes.getArchived() == null){
            attributeTypes.setArchived(Boolean.FALSE);
        }
        if(validator.isValidParams(attributeTypes)) {
            repository.save(attributeTypes);
            return attributeTypes;
        }
        throw new IllegalArgumentException("Entity params couldn't be nullable!");
    }

    @Override
    public AttributeTypes updateById(Integer id, AttributeTypesDto dto) {
        AttributeTypes attributeTypes = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Attribute type with id: " + id + " not found!"));
        attributeTypes = assertDifferencesUpdates.assertAttributeTypesAndDto(attributeTypes, dto);
        repository.save(attributeTypes);
        return attributeTypes;

    }

    @Override
    public AttributeTypes archiveById(Integer id) {
        AttributeTypes attributeTypes = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Attribute type with id: " + id + " not found!"));
        attributeTypes.setArchived(Boolean.TRUE);
        repository.save(attributeTypes);
        return attributeTypes;
    }
}
