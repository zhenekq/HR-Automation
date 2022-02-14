package by.mifort.automation.hr.dev.dto;

import by.mifort.automation.hr.dev.entity.People;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;
import java.util.Set;

/**
 * Data transfer object for entity Keyword
 * @see by.mifort.automation.hr.dev.entity.Keyword
 * @author yauheni_vozny
 * @version 1.0
 */

public class KeywordDto {

    private String id;

    public KeywordDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
