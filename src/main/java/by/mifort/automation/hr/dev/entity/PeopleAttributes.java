package by.mifort.automation.hr.dev.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "peopleattributes")
public class PeopleAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private Integer type;

    @Column(name = "value")
    private String name;

    @Column(name = "valuesource")
    private Integer valueSource;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private People human;

    public PeopleAttributes() {
    }

    public PeopleAttributes(Integer id, Integer type, String name, Integer valueSource, People human) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.valueSource = valueSource;
        this.human = human;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValueSource() {
        return valueSource;
    }

    public void setValueSource(Integer valueSource) {
        this.valueSource = valueSource;
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
        PeopleAttributes that = (PeopleAttributes) o;
        return id.equals(that.id) && type.equals(that.type) && name.equals(that.name) && valueSource.equals(that.valueSource) && human.equals(that.human);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, valueSource, human);
    }

    @Override
    public String toString() {
        return "PeopleAttributes{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", valueSource=" + valueSource +
                ", human=" + human +
                '}';
    }
}
