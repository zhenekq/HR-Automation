package by.mifort.automation.hr.dev.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Communication history with candidate
 * @author yauheni_vozny
 * @version 1.0
 */

@Entity
@Table(name = "communication_history")
public class CommunicationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createdate", nullable = false)
    private Timestamp createDate;

    @Column(name = "updatedate")
    private Timestamp updateDate;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private People human;

    public CommunicationHistory() {
    }

    public CommunicationHistory(Integer id, Timestamp createDate, Timestamp updateDate, String comment, People human) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.comment = comment;
        this.human = human;
    }

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

    public People getHuman() {
        return human;
    }

    public void setHuman(People human) {
        this.human = human;
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
