package by.mifort.automation.hr.dev.service.duplicates;

import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Utils class for candidate's duplicates
 *
 * @author yauheni_vozny
 * @version 1.0
 * @see DuplicatesStrategy
 */
public class DuplicatesStrategyUtils {

    private DuplicatesStrategyUtils(){}

    /**
     * @author yauheni_vozny
     * @return Arrays of arrays duplicates by one similar attribute
     */
    public static List<List<CandidateAttributes>> separate(List<CandidateAttributes> attributes){
        List<List<CandidateAttributes>> result = new ArrayList<>();
        for(int i=0;i<attributes.size();i++){
            List<CandidateAttributes> logCandidates = new ArrayList<>();
            logCandidates.add(attributes.get(i));
            for(int j=i+1;j<attributes.size();j++){
                if(attributes.get(i).getValue().equals(attributes.get(j).getValue()) && i!=j){
                    logCandidates.add(attributes.get(j));
                    i++;
                }
            }
            result.add(logCandidates);
        }
        return result;
    }

    public static void isEnumContainsValue(String value){
        for(DuplicatesStrategyName name: DuplicatesStrategyName.values()){
            if(!name.name().equals(value)){
                throw new IllegalArgumentException("Cannot find strategy like this");
            }
        }
    }
}
