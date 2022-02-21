package by.mifort.automation.hr.dev.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Data transfer object for entity CandidateUpdates
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see by.mifort.automation.hr.dev.entity.CandidateUpdate
 */
public class CandidateUpdateDto {
    private Integer id;
    private String source;
    private Timestamp updateDate;
    private Map<String, String> changeSet;

    public CandidateUpdateDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @JsonAnyGetter
    public Map<String, String> getChangeSet() {
        return changeSet;
    }

    @JsonAnySetter
    public void setChangeSet(Map<String, String> changeSet) {
        this.changeSet = changeSet;
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
