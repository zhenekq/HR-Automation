package by.mifort.automation.hr.dev.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Updates about candidate
 * @author yauheni_vozny
 * @version 1.0
 * */

@Entity
@Table(name = "peopleupdates")
public class PeopleUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "updatedate")
    private Timestamp updateDate;

    @Column(name = "changeset", columnDefinition = "json")
    private String changeSet;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private People human;

    public PeopleUpdate() {
    }

    public PeopleUpdate(Integer id, String source, Timestamp updateDate, String changeSet, People human) {
        this.id = id;
        this.source = source;
        this.updateDate = updateDate;
        this.changeSet = changeSet;
        this.human = human;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getChangeSet() {
        return changeSet;
    }

    public void setChangeSet(String changeSet) {
        this.changeSet = changeSet;
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
