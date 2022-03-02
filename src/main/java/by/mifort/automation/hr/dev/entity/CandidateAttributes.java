package by.mifort.automation.hr.dev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * People attributes that connected with candidate
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see AttributeTypes connected attributes with types
 */
@Entity
@Table(name = "peopleattributes")
public class CandidateAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    private String value;

    @Column(name = "valuesource")
    private Integer valueSource;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private AttributeTypes attributeTypes;

    public CandidateAttributes() {
    }

    public CandidateAttributes(Integer id, String value, Integer valueSource, Candidate candidate, AttributeTypes attributeTypes) {
        this.id = id;
        this.value = value;
        this.valueSource = valueSource;
        this.candidate = candidate;
        this.attributeTypes = attributeTypes;
    }

    public CandidateAttributes(String value, Integer valueSource) {
        this.value = value;
        this.valueSource = valueSource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getValueSource() {
        return valueSource;
    }

    public void setValueSource(Integer valueSource) {
        this.valueSource = valueSource;
    }

    @JsonIgnore
    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public AttributeTypes getAttributeTypes() {
        return attributeTypes;
    }

    public void setAttributeTypes(AttributeTypes attributeTypes) {
        this.attributeTypes = attributeTypes;
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
