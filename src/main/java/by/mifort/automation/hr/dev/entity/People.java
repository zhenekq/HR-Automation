package by.mifort.automation.hr.dev.entity;

import by.mifort.automation.hr.dev.util.StringPrefixedSequenceIdGenerator;
import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.sql.Timestamp;
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

    public People(){}

    public People(String id, Timestamp lastContact, String status) {
        this.id = id;
        this.lastContact = lastContact;
        this.status = status;
    }

    public People(Timestamp lastContact, String status) {
        this.lastContact = lastContact;
        this.status = status;
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
}
