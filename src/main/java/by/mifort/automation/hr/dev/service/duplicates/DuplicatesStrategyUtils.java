package by.mifort.automation.hr.dev.service.duplicates;

import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Utils class for candidate's duplicates
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see DuplicatesStrategy
 */
public class DuplicatesStrategyUtils {

    /**
     * @author yauheni_vozny
     * @return Arrays of arrays duplicates by one similar attribute
     */
    public static List<List<Candidate>> separate(List<CandidateAttributes> attributes, Comparator<CandidateAttributes> comparator){
        List<List<Candidate>> result = new ArrayList<>();
        for(int i=0;i<attributes.size();i++){
            List<Candidate> logCandidates = new ArrayList<>();
            logCandidates.add(attributes.get(i).getCandidate());
            for(int j=0;j<attributes.size();j++){
                if(comparator.compare(attributes.get(i), attributes.get(j)) == 0 && i != j){
                    logCandidates.add(attributes.get(j).getCandidate());
                    attributes.remove(j);
                    j--;
                }
            }
            result.add(logCandidates);
        }
        return result;
    }
}
