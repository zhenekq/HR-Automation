package by.mifort.automation.hr.dev.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * People attributes that connected with candidate
 * @see AttributeTypes connected attributes with types
 * @author yauheni_vozny
 * @version 1.0
 */

@Entity
@Table(name = "peopleattributes")
public class PeopleAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    private String name;

    @Column(name = "valuesource")
    private Integer valueSource;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private People human;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private AttributeTypes attributeTypes;

    public PeopleAttributes() {
    }

    public PeopleAttributes(Integer id, Integer type, String name, Integer valueSource, People human) {
        this.id = id;
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
