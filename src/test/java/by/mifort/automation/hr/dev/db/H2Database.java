package by.mifort.automation.hr.dev.db;

import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomUtils;

import java.sql.Timestamp;
import java.util.List;

public class H2Database {
    private static final H2Database instance = new H2Database();

    private H2Database(){}

    public static H2Database getInstance() {
        return instance;
    }

    public List<Candidate> initializeCandidates(){
        return List.of(
                new Candidate("yauheni_vozny", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("artem_skrebets", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("stas_gutsko", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("uliana_fomina", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("vladimir_zelmanchuk", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("empty_candidate", new Timestamp(RandomUtils.nextLong()), RandomString.make())
        );
    }

    public List<CommunicationHistory> initializeHistories(){
        return List.of(
                new CommunicationHistory(1, new Timestamp(RandomUtils.nextLong()),new Timestamp(RandomUtils.nextLong()), "comment1", Boolean.FALSE, new Candidate("yauheni_vozny")),
                new CommunicationHistory(2, new Timestamp(RandomUtils.nextLong()),new Timestamp(RandomUtils.nextLong()), "comment2", Boolean.FALSE, new Candidate("artem_skrebets")),
                new CommunicationHistory(3, new Timestamp(RandomUtils.nextLong()),new Timestamp(RandomUtils.nextLong()), "comment3", Boolean.FALSE, new Candidate("stas_gutsko")),
                new CommunicationHistory(4, new Timestamp(RandomUtils.nextLong()),new Timestamp(RandomUtils.nextLong()), "comment4", Boolean.FALSE, new Candidate("uliana_fomina")),
                new CommunicationHistory(5, new Timestamp(RandomUtils.nextLong()),new Timestamp(RandomUtils.nextLong()), "comment5", Boolean.FALSE, new Candidate("vladimir_zelmanchuk")),
                new CommunicationHistory(6, new Timestamp(RandomUtils.nextLong()),new Timestamp(RandomUtils.nextLong()), "comment6", Boolean.TRUE, new Candidate("yauheni_vozny")),
                new CommunicationHistory(7, new Timestamp(RandomUtils.nextLong()),new Timestamp(RandomUtils.nextLong()), "comment7", Boolean.TRUE, new Candidate("yauheni_vozny"))
        );
    }
}
