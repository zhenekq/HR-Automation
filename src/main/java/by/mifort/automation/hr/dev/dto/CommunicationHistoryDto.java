package by.mifort.automation.hr.dev.dto;

import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Data transfer object for entity CommunicationHistory
 * @see by.mifort.automation.hr.dev.entity.CommunicationHistory
 * @author yauheni_vozny
 * @version 1.0
 */

public class CommunicationHistoryDto {

    private Integer id;
    private Timestamp createDate;
    private Timestamp updateDate;
    private String comment;
    private PeopleDto human;

    public CommunicationHistoryDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
