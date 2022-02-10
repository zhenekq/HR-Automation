package by.mifort.automation.hr.dev.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * People merge candidates entity
 * @author yauheni_vozny
 * @version 1.0
 */

@Entity
@Table(name = "people_merge_candidates")
public class PeopleMergeCandidates implements Serializable {

    @EmbeddedId
    private MergeCandidates mergeCandidates;

    @Column(name = "status")
    private String status;

    @Column(name = "reason")
    private String reason;

    @Column(name = "reasoncomment")
    private String reasonComment;

    /**
     * @see People Join 2 primary keys like a foreign key for 1 primary key
     * */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "user1Id",
                    referencedColumnName = "id",
                    nullable = false,
                    insertable = false,
                    updatable = false
            ),
            @JoinColumn(
                    name = "user2Id",
                    referencedColumnName = "id",
                    nullable = false,
                    insertable = false,
                    updatable = false
            )
    })
    private People human;

    public PeopleMergeCandidates() {}

    public PeopleMergeCandidates(MergeCandidates mergeCandidates, String status, String reason, String reasonComment) {
        this.mergeCandidates = mergeCandidates;
        this.status = status;
        this.reason = reason;
        this.reasonComment = reasonComment;
    }

    public MergeCandidates getMergeCandidates() {
        return mergeCandidates;
    }

    public void setMergeCandidates(MergeCandidates mergeCandidates) {
        this.mergeCandidates = mergeCandidates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReasonComment() {
        return reasonComment;
    }

    public void setReasonComment(String reasonComment) {
        this.reasonComment = reasonComment;
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
