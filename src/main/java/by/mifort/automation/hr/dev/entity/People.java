package by.mifort.automation.hr.dev.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * Head entity "people" that has all information
 * @author yauheni_vozny
 * @version 1.0
 */

@Entity
@Table(name = "people")
public class People {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "lastcontact")
    private Timestamp lastContact;

    @Column(name = "status")
    private String status;

    /**
     * Information about candidate updates
     * @see PeopleUpdate
     */
    @OneToMany(mappedBy = "human")
    private Set<PeopleUpdate> humanUpdates;

    /**
     * Keyboards that connection with candidate
     * @see Keyword
     */
    @OneToMany(mappedBy = "human")
    private Set<Keyword> humanKeywords;

    /**
     * Communication history with candidate
     * @see CommunicationHistory
     */
    @OneToMany(mappedBy = "human")
    private Set<CommunicationHistory> communicationHistory;

    /**
     * Attributes that connected with candidate
     * @see PeopleAttributes
     */
    @OneToMany(mappedBy = "human")
    private Set<PeopleAttributes> humanAttributes;

    public People() {
    }

    public People(String id, Timestamp lastContact, String status) {
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

    public Set<PeopleUpdate> getHumanUpdates() {
        return humanUpdates;
    }

    public void setHumanUpdates(Set<PeopleUpdate> humanUpdates) {
        this.humanUpdates = humanUpdates;
    }

    public Set<Keyword> getHumanKeywords() {
        return humanKeywords;
    }

    public void setHumanKeywords(Set<Keyword> humanKeywords) {
        this.humanKeywords = humanKeywords;
    }

    public Set<CommunicationHistory> getCommunicationHistory() {
        return communicationHistory;
    }

    public void setCommunicationHistory(Set<CommunicationHistory> communicationHistory) {
        this.communicationHistory = communicationHistory;
    }

    public Set<PeopleAttributes> getHumanAttributes() {
        return humanAttributes;
    }

    public void setHumanAttributes(Set<PeopleAttributes> humanAttributes) {
        this.humanAttributes = humanAttributes;
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
