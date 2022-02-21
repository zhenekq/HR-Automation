package by.mifort.automation.hr.dev.service.impl;

import by.mifort.automation.hr.dev.dto.AttributeTypesDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.AttributeTypes;
import by.mifort.automation.hr.dev.repository.AttributeTypesRepository;
import by.mifort.automation.hr.dev.service.AttributeTypesService;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeTypesServiceImpl implements AttributeTypesService {

    private final AttributeTypesRepository repository;
    private final EntityConverter<AttributeTypes, AttributeTypesDto> converter;

    @Autowired
    public AttributeTypesServiceImpl(AttributeTypesRepository repository, EntityConverter<AttributeTypes, AttributeTypesDto> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<AttributeTypesDto> getAll(FilterDto filterDto) {
        Integer page = filterDto.getPageNumber();
        Integer amount = filterDto.getPageSize();
        Pageable pageable = PageRequest.of(page - 1, amount);
        List<AttributeTypes> attributeTypes = repository.findAll(pageable).toList();
        return converter.convertToListEntityDto(attributeTypes);
    }

    @Override
    public AttributeTypesDto create(AttributeTypesDto dto) {
        return null;
    }

    @Override
    public AttributeTypesDto updateById(Integer id, AttributeTypesDto dto) {
        return null;
    }

    @Override
    public AttributeTypesDto archiveById(Integer id) {
        return null;
    }
}
