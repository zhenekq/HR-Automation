package by.mifort.automation.hr.dev.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "keywords")
public class Keyword {
    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private People human;

    public Keyword() {
    }

    public Keyword(String id, People human) {
        this.id = id;
        this.human = human;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        Keyword keyword = (Keyword) o;
        return id.equals(keyword.id) && human.equals(keyword.human);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, human);
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id='" + id + '\'' +
                ", human=" + human +
                '}';
    }
}
