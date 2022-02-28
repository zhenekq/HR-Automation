package by.mifort.automation.hr.dev.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * People merge candidates entity
 *
 * @author yauheni_vozny
 * @version 1.0
 */

@Entity
@Table(name = "people_merge_candidates")
public class CandidateMergeCandidates {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "status")
    private String status;

    @Column(name = "reason")
    private String reason;

    @Column(name = "reasoncomment")
    private String reasonComment;

    /**
     * @see Candidate Join 2 primary keys like a foreign key for 1 primary key
     */

    /*@ManyToOne(fetch = FetchType.LAZY)
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
    private Candidate candidate;*/
    public CandidateMergeCandidates() {
    }

    public CandidateMergeCandidates(String status, String reason, String reasonComment) {
        this.status = status;
        this.reason = reason;
        this.reasonComment = reasonComment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
