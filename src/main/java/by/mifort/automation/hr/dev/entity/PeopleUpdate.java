package by.mifort.automation.hr.dev.entity;

import by.mifort.automation.hr.dev.service.PeopleService;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.sql.Timestamp;

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
}
