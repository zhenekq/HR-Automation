package by.mifort.automation.hr.dev.dto;

import by.mifort.automation.hr.dev.entity.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class PeopleDto {

    private String id;
    private Timestamp lastContact;
    private String status;
    private Set<PeopleUpdate> peopleUpdates = new HashSet<>();
    private Set<Keyword> keywords = new HashSet<>();
    private Set<CommunicationHistory> communicationHistory = new HashSet<>();
    private Set<PeopleAttributes> peopleAttributes = new HashSet<>();
    private Set<PeopleMergeCandidates> mergeCandidates = new HashSet<>();

    public PeopleDto() {
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

    public Set<PeopleUpdate> getPeopleUpdates() {
        return peopleUpdates;
    }

    public void setPeopleUpdates(Set<PeopleUpdate> peopleUpdates) {
        this.peopleUpdates = peopleUpdates;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Set<CommunicationHistory> getCommunicationHistory() {
        return communicationHistory;
    }

    public void setCommunicationHistory(Set<CommunicationHistory> communicationHistory) {
        this.communicationHistory = communicationHistory;
    }

    public Set<PeopleAttributes> getPeopleAttributes() {
        return peopleAttributes;
    }

    public void setPeopleAttributes(Set<PeopleAttributes> peopleAttributes) {
        this.peopleAttributes = peopleAttributes;
    }

    public Set<PeopleMergeCandidates> getMergeCandidates() {
        return mergeCandidates;
    }

    public void setMergeCandidates(Set<PeopleMergeCandidates> mergeCandidates) {
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
