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

/**
 * Head entity "people" that has all information
 *
 * @author yauheni_vozny
 * @version 1.0
 */

@Entity
@Table(name = "people", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate implements Serializable {

    @Id
    private String id;

    @Column(name = "lastcontact")
    private Timestamp lastContact;

    @Column(name = "status")
    private String status;

    /**
     * Information about candidate updates
     *
     * @see CandidateUpdate
     */
    @OneToMany(mappedBy = "candidate")
    private List<CandidateUpdate> updates;

    /**
     * Keyboards that connection with candidate
     *
     * @see Keyword
     */
    @OneToMany(mappedBy = "candidate")
    private List<Keyword> keywords;

    /**
     * Communication history with candidate
     *
     * @see CommunicationHistory
     */
    @OneToMany(mappedBy = "candidate")
    private List<CommunicationHistory> communicationHistory;

    /**
     * Attributes that connected with candidate
     *
     * @see CandidateAttributes
     */
    @OneToMany(mappedBy = "candidate")
    private List<CandidateAttributes> attributes;


    /**
     * Merged candidates
     *
     * @see CandidateMergeCandidates
     */
    @OneToMany(mappedBy = "candidate")
    private List<CandidateMergeCandidates> mergeCandidates;

    public Candidate() {
    }

    public Candidate(String id) {
        this.id = id;
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
    public List<CandidateUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(List<CandidateUpdate> updates) {
        this.updates = updates;
    }

    @JsonIgnore
    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    @JsonIgnore
    public List<CommunicationHistory> getCommunicationHistory() {
        return communicationHistory;
    }

    public void setCommunicationHistory(List<CommunicationHistory> communicationHistory) {
        this.communicationHistory = communicationHistory;
    }

    @JsonIgnore
    public List<CandidateAttributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CandidateAttributes> attributes) {
        this.attributes = attributes;
    }

    @JsonIgnore
    public List<CandidateMergeCandidates> getMergeCandidates() {
        return mergeCandidates;
    }

    public void setMergeCandidates(List<CandidateMergeCandidates> mergeCandidates) {
        this.mergeCandidates = mergeCandidates;
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
