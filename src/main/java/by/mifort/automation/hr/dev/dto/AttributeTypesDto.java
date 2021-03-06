package by.mifort.automation.hr.dev.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data transfer object for entity AttributeTypes
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see by.mifort.automation.hr.dev.entity.AttributeTypes
 */
public class AttributeTypesDto {

    private Integer id;
    private String name;
    private String basicType;
    private String validation;
    private Boolean isIdentifier;
    private Boolean isArchived;

    public AttributeTypesDto() {
    }

    public AttributeTypesDto(Integer id, String name, String basicType, String validation, Boolean isIdentifier, Boolean isArchived) {
        this.id = id;
        this.name = name;
        this.basicType = basicType;
        this.validation = validation;
        this.isIdentifier = isIdentifier;
        this.isArchived = isArchived;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasicType() {
        return basicType;
    }

    public void setBasicType(String basicType) {
        this.basicType = basicType;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public Boolean getIdentifier() {
        return isIdentifier;
    }

    public void setIdentifier(Boolean identifier) {
        isIdentifier = identifier;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
