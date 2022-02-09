package by.mifort.automation.hr.dev.entity;

import by.mifort.automation.hr.dev.util.StringPrefixedSequenceIdGenerator;
import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "people")
public class People {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "lastcontact")
    private Timestamp lastContact;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "human")
    private Set<PeopleUpdate> humanUpdates ;

    @OneToMany(mappedBy = "human")
    private Set<Keyword> humanKeywords;

    @OneToMany(mappedBy = "human")
    private Set<CommunicationHistory> communicationHistory;

    @OneToMany(mappedBy = "human")
    private Set<PeopleAttributes> humanAttributes;

    public People(){}

    public People(String id, Timestamp lastContact, String status) {
        this.id = id;
        this.lastContact = lastContact;
        this.status = status;
    }

    public People(String id, Timestamp lastContact, String status, Set<PeopleUpdate> humanUpdates, Set<Keyword> humanKeywords, Set<CommunicationHistory> communicationHistory, Set<PeopleAttributes> humanAttributes) {
        this.id = id;
        this.lastContact = lastContact;
        this.status = status;
        this.humanUpdates = humanUpdates;
        this.humanKeywords = humanKeywords;
        this.communicationHistory = communicationHistory;
        this.humanAttributes = humanAttributes;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return id.equals(people.id) && lastContact.equals(people.lastContact) && status.equals(people.status) && humanUpdates.equals(people.humanUpdates) && humanKeywords.equals(people.humanKeywords) && communicationHistory.equals(people.communicationHistory) && humanAttributes.equals(people.humanAttributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastContact, status, humanUpdates, humanKeywords, communicationHistory, humanAttributes);
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", lastContact=" + lastContact +
                ", status='" + status + '\'' +
                ", humanUpdates=" + humanUpdates +
                ", humanKeywords=" + humanKeywords +
                ", communicationHistory=" + communicationHistory +
                ", humanAttributes=" + humanAttributes +
                '}';
    }
}
