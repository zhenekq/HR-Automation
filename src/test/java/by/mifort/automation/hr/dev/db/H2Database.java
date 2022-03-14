package by.mifort.automation.hr.dev.db;

import by.mifort.automation.hr.dev.entity.*;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomUtils;
import org.checkerframework.checker.units.qual.C;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<AttributeTypes> initializeAttributeTypes(){
        return List.of(
                new AttributeTypes(1, RandomString.make(),RandomString.make(), RandomString.make(), true, Boolean.FALSE),
                new AttributeTypes(2, RandomString.make(),RandomString.make(), RandomString.make(), true, Boolean.FALSE),
                new AttributeTypes(3, RandomString.make(),RandomString.make(), RandomString.make(), true, Boolean.FALSE),
                new AttributeTypes(4, RandomString.make(),RandomString.make(), RandomString.make(), true, Boolean.FALSE),
                new AttributeTypes(5, RandomString.make(),RandomString.make(), RandomString.make(), true, Boolean.FALSE),
                new AttributeTypes(6, RandomString.make(),RandomString.make(), RandomString.make(), true, Boolean.FALSE),
                new AttributeTypes(7, RandomString.make(),RandomString.make(), RandomString.make(), true, Boolean.TRUE),
                new AttributeTypes(8, RandomString.make(),RandomString.make(), RandomString.make(), true, Boolean.TRUE)
        );
    }

    public List<CandidateAttributes> initializeCandidateAttributes(){
        return List.of(
                new CandidateAttributes(1,  RandomString.make(), RandomUtils.nextInt(), new Candidate("yauheni_vozny"), new AttributeTypes(1)),
                new CandidateAttributes(2,  RandomString.make(), RandomUtils.nextInt(), new Candidate("artem_skrebets"), new AttributeTypes(2)),
                new CandidateAttributes(3,  RandomString.make(), RandomUtils.nextInt(), new Candidate("stas_gutsko"), new AttributeTypes(3)),
                new CandidateAttributes(4,  RandomString.make(), RandomUtils.nextInt(), new Candidate("uliana_fomina"), new AttributeTypes(4)),
                new CandidateAttributes(5,  RandomString.make(), RandomUtils.nextInt(), new Candidate("vladimir_zelmanchuk"), new AttributeTypes(5)),
                new CandidateAttributes(6,  RandomString.make(), RandomUtils.nextInt(), new Candidate("yauheni_vozny"), new AttributeTypes(6))
        );
    }

    public List<CandidateUpdate> initializeCandidateUpdates(){
        return List.of(
                new CandidateUpdate(1, RandomString.make(), new Timestamp(RandomUtils.nextLong()), getChangeSet(), new Candidate("yauheni_vozny")),
                new CandidateUpdate(2, RandomString.make(), new Timestamp(RandomUtils.nextLong()), getChangeSet(), new Candidate("artem_skrebets")),
                new CandidateUpdate(3, RandomString.make(), new Timestamp(RandomUtils.nextLong()), getChangeSet(), new Candidate("stas_gutsko")),
                new CandidateUpdate(4, RandomString.make(), new Timestamp(RandomUtils.nextLong()), getChangeSet(), new Candidate("uliana_fomina")),
                new CandidateUpdate(5, RandomString.make(), new Timestamp(RandomUtils.nextLong()), getChangeSet(), new Candidate("vladimir_zelmanchuk")),
                new CandidateUpdate(6, RandomString.make(), new Timestamp(RandomUtils.nextLong()), getChangeSet(), new Candidate("yauheni_vozny"))
        );
    }

    private Map<String, String> getChangeSet(){
        Map<String, String> changeSet = new HashMap<>();
        changeSet.put("key1", "value1");
        changeSet.put("key2", "value2");
        changeSet.put("key3", "value3");

        return changeSet;
    }

    public CandidateUpdate getRandomCandidateUpdate(){
        return new CandidateUpdate(RandomUtils.nextInt(),
                                   RandomString.make(),
                                   new Timestamp(RandomUtils.nextLong()),
                                   getChangeSet(),
                                   new Candidate(RandomString.make()));
    }

    public AttributeTypes getAttributeTypeWithRandomValues(){
         return new AttributeTypes(RandomString.make(),
                                   RandomString.make(),
                                   RandomString.make(),
                                   RandomUtils.nextBoolean(),
                                   RandomUtils.nextBoolean());
    }

    public CandidateAttributes getCandidateAttributesWithRandomValues(String candidateId, Integer type){
        CandidateAttributes attributes = new CandidateAttributes(RandomString.make(), RandomUtils.nextInt());
        attributes.setCandidate(new Candidate(candidateId));
        attributes.setAttributeTypes(new AttributeTypes(type));

        return attributes;
    }

    public Candidate getCandidateWithRandomValues(){
        return new Candidate(RandomString.make(),
                              new Timestamp(RandomUtils.nextLong()),
                              RandomString.make());
    }
}
