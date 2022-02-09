package by.mifort.automation.hr.dev.entity;

import javax.persistence.*;
import java.util.Objects;

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

    /*Is primary key for this table,
      will use like a foreign key,
      that connected with table peopleattributes
       with field "type" ???
    */

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeTypes that = (AttributeTypes) o;
        return id.equals(that.id) && name.equals(that.name) && basicType.equals(that.basicType) && validation.equals(that.validation) && isIdentifier.equals(that.isIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, basicType, validation, isIdentifier);
    }

    @Override
    public String toString() {
        return "AttributeTypes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basicType='" + basicType + '\'' +
                ", validation='" + validation + '\'' +
                ", isIdentifier=" + isIdentifier +
                '}';
    }
}
