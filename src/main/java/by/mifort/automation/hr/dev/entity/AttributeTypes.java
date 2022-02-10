package by.mifort.automation.hr.dev.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

/**
 * Attribute types of people attributes
 * @author yauheni_vozny
 * @version 1.0
 */

@Entity
@Table(name = "attributetypes")
public class AttributeTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "basictype")
    private String basicType;

    @Column(name = "validation")
    private String validation;

    @Column(name = "isidentifier")
    private Boolean isIdentifier;

    @OneToMany(mappedBy = "attributeTypes")
    private Set<PeopleAttributes> peopleAttributes;

    public AttributeTypes() {
    }

    public AttributeTypes(Integer id, String name, String basicType, String validation, Boolean isIdentifier) {
        this.id = id;
        this.name = name;
        this.basicType = basicType;
        this.validation = validation;
        this.isIdentifier = isIdentifier;
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
