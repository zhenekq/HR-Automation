package by.mifort.automation.hr.dev.entity;

import by.mifort.automation.hr.dev.service.PeopleService;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "peopleupdates")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class)
        ,
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class PeopleUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "updatedate")
    private Timestamp updateDate;

    @Type(type = "jsonb")
    @Column(name = "changeset")
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeopleUpdate that = (PeopleUpdate) o;
        return id.equals(that.id) && source.equals(that.source) && updateDate.equals(that.updateDate) && changeSet.equals(that.changeSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, updateDate, changeSet);
    }

    @Override
    public String toString() {
        return "PeopleUpdate{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", updateDate=" + updateDate +
                ", changeSet='" + changeSet + '\'' +
                ", human=" + human +
                '}';
    }
}
