package by.mifort.automation.hr.dev.service.duplicates;

import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.repository.CandidateRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
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
    public static List<List<Candidate>> separate(List<CandidateAttributes> attributes){
        List<List<Candidate>> result = new ArrayList<>();
        for(int i=0;i<attributes.size();i++){
            List<Candidate> logCandidates = new ArrayList<>();
            logCandidates.add(attributes.get(i).getCandidate());
            for(int j=0;j<attributes.size();j++){
                if(attributes.get(i).getValue().equals(attributes.get(j).getValue()) && i!=j){
                    logCandidates.add(attributes.get(j).getCandidate());
                    attributes.remove(j);
                    j--;
                }
            }
            result.add(logCandidates);
        }
        return result;
    }

    public static List<List<Candidate>> separate2(List<CandidateAttributes> attributes){
        List<List<Candidate>> res = new ArrayList<>();
        String current = null;
        int counter = 0;
        List<Candidate> attributesList = new ArrayList<>();
        for(int i=0;i<attributes.size();i++){
            if(!attributes.get(i).getValue().equals(current)){
                if(counter > 1){
                    res.add(attributesList);
                }
                current = attributes.get(i).getValue();
                counter = 1;
            }else{
                counter++;
                attributesList.add(attributes.get(i).getCandidate());
            }
        }
        if(counter > 1){
            res.add(attributesList);
        }
        return res;
    }
}
