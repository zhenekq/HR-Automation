package by.mifort.automation.hr.dev.util.differences.impl;

import by.mifort.automation.hr.dev.dto.CandidateAttributesDto;
import by.mifort.automation.hr.dev.entity.CandidateAttributes;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AsserDifferencesCandidateListAttributes {

    private final EntityConverter<CandidateAttributes, CandidateAttributesDto> converter;

    public AsserDifferencesCandidateListAttributes(EntityConverter<CandidateAttributes, CandidateAttributesDto> converter){
        this.converter = converter;
    }

    public static List<CandidateAttributes> assertDiff(List<CandidateAttributes> db, List<CandidateAttributes> body){
        if(db == null){
            return body;
        }
        Set<CandidateAttributes> resultDto = new HashSet<>();
        for(int i=0;i<body.size();i++){
            CandidateAttributes dbDto = body.get(i);
            Integer dbDtoId = dbDto.getAttributeTypes().getId();
            CandidateAttributes dbBody = null;
            boolean isExists = false;
            for(int j=0;j<db.size();j++){
                dbBody = db.get(j);
                Integer dbBodyId = dbBody.getAttributeTypes().getId();
                if(dbBodyId.equals(dbDtoId)){
                    isExists = true;
                    break;
                }
            }
            if(!isExists){
                resultDto.add(dbDto);
            }
        }
        return resultDto.stream().toList();
    }
}
