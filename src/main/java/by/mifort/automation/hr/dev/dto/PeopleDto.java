package by.mifort.automation.hr.dev.dto;

import by.mifort.automation.hr.dev.entity.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Data transfer object for entity People
 * @see People
 * @author yauheni_vozny
 * @version 1.0
 */

public class PeopleDto {

    private String id;
    private Timestamp lastContact;
    private String status;
    private List<PeopleUpdate> peopleUpdates = new ArrayList<>();
    private List<KeywordDto> keywords = new ArrayList<>();
    private List<CommunicationHistory> communicationHistory = new ArrayList<>();
    private List<PeopleAttributes> peopleAttributes = new ArrayList<>();
    private List<PeopleMergeCandidates> mergeCandidates = new ArrayList<>();

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

    public List<PeopleUpdate> getPeopleUpdates() {
        return peopleUpdates;
    }

    public void setPeopleUpdates(List<PeopleUpdate> peopleUpdates) {
        this.peopleUpdates = peopleUpdates;
    }

    public List<KeywordDto> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<KeywordDto> keywords) {
        this.keywords = keywords;
    }

    public List<CommunicationHistory> getCommunicationHistory() {
        return communicationHistory;
    }

    public void setCommunicationHistory(List<CommunicationHistory> communicationHistory) {
        this.communicationHistory = communicationHistory;
    }

    public List<PeopleAttributes> getPeopleAttributes() {
        return peopleAttributes;
    }

    public void setPeopleAttributes(List<PeopleAttributes> peopleAttributes) {
        this.peopleAttributes = peopleAttributes;
    }

    public List<PeopleMergeCandidates> getMergeCandidates() {
        return mergeCandidates;
    }

    public void setMergeCandidates(List<PeopleMergeCandidates> mergeCandidates) {
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
