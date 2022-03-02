package by.mifort.automation.hr.dev.util;

import by.mifort.automation.hr.dev.entity.AttributeTypes;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;

public class Utils {

    private Utils(){}

    public static void setCandidateAttribute(String candidateId, CandidateAttributes attributes, Integer type){
        Candidate candidate = new Candidate();
        candidate.setId(candidateId);
        attributes.setCandidate(candidate);
        AttributeTypes types = new AttributeTypes();
        types.setId(type);
        attributes.setAttributeTypes(types);
    }
}
