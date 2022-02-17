package by.mifort.automation.hr.dev.util;

import java.util.List;

public interface ValidationEntityDtoComponent <EntityDto> {

    boolean isValidEntityDto(EntityDto entity);

    boolean isValidEntityDtoList(List<EntityDto> entityDtoList);
}
