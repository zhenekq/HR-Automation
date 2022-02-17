package by.mifort.automation.hr.dev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * Head entity "people" that has all information
 * @author yauheni_vozny
 * @version 1.0
 */

@Entity
@Table(name = "people", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "lastcontact")
    private Timestamp lastContact;

    @Column(name = "status")
    private String status;

    /**
     * Information about candidate updates
     * @see CandidateUpdate
     */
    @OneToMany(mappedBy = "candidate")
    private List<CandidateUpdate> candidateUpdates;

    /**
     * Keyboards that connection with candidate
     * @see Keyword
     */
    @OneToMany(mappedBy = "candidate")
    private List<Keyword> candidateKeywords;

    /**
     * Communication history with candidate
     * @see CommunicationHistory
     */
    @OneToMany(mappedBy = "candidate")
    private List<CommunicationHistory> candidateCommunicationHistory;

    /**
     * Attributes that connected with candidate
     * @see CandidateAttributes
     */
    @OneToMany(mappedBy = "candidate")
    private List<CandidateAttributes> candidateAttributes;


    /**
     * Merged candidates
     * @see CandidateMergeCandidates
     */
    @OneToMany(mappedBy = "candidate")
    private List<CandidateMergeCandidates> candidates;

    public Candidate() {
    }

    public Candidate(String id, Timestamp lastContact, String status) {
        this.id = id;
        this.lastContact = lastContact;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Timestamp getLastContact() {
        return lastContact;
    }

    public void setLastContact(Timestamp lastContact) {
        this.lastContact = lastContact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonIgnore
    public List<CandidateUpdate> getCandidateUpdates() {
        return candidateUpdates;
    }

    public void setCandidateUpdates(List<CandidateUpdate> candidateUpdates) {
        this.candidateUpdates = candidateUpdates;
    }

    @JsonIgnore
    public List<Keyword> getCandidateKeywords() {
        return candidateKeywords;
    }

    public void setCandidateKeywords(List<Keyword> candidateKeywords) {
        this.candidateKeywords = candidateKeywords;
    }

    @JsonIgnore
    public List<CommunicationHistory> getCandidateCommunicationHistory() {
        return candidateCommunicationHistory;
    }

    public void setCandidateCommunicationHistory(List<CommunicationHistory> candidateCommunicationHistory) {
        this.candidateCommunicationHistory = candidateCommunicationHistory;
    }

    @JsonIgnore
    public List<CandidateAttributes> getCandidateAttributes() {
        return candidateAttributes;
    }

    public void setCandidateAttributes(List<CandidateAttributes> candidateAttributes) {
        this.candidateAttributes = candidateAttributes;
    }

    @JsonIgnore
    public List<CandidateMergeCandidates> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<CandidateMergeCandidates> candidates) {
        this.candidates = candidates;
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
