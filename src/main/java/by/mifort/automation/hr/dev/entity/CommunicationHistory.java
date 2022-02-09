package by.mifort.automation.hr.dev.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "communication_history")
public class CommunicationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createdate", nullable = false)
    private Timestamp createDate;

    @Column(name = "updatedate")
    private Timestamp updateDate;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private People human;

    public CommunicationHistory() {
    }

    public CommunicationHistory(Integer id, Timestamp createDate, Timestamp updateDate, String comment, People human) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.comment = comment;
        this.human = human;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        CommunicationHistory that = (CommunicationHistory) o;
        return id.equals(that.id) && createDate.equals(that.createDate) && updateDate.equals(that.updateDate) && comment.equals(that.comment) && human.equals(that.human);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createDate, updateDate, comment, human);
    }

    @Override
    public String toString() {
        return "CommunicationHistory{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", comment='" + comment + '\'' +
                ", human=" + human +
                '}';
    }
}
