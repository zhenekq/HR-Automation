package by.mifort.automation.hr.dev.util.impl;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.dto.KeywordDto;
import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.entity.Keyword;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.util.MappingDtoComponentConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MappingDtoComponentConverterImpl implements MappingDtoComponentConverter {
    @Override
    public CandidateDto convertToPeopleDto(Candidate candidate) {
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setId(candidate.getId());
        candidateDto.setStatus(candidate.getStatus());
        candidateDto.setLastContact(candidate.getLastContact());
        candidateDto.setKeywords(convertToListKeywordDto(candidate.getHumanKeywords()));
        candidateDto.setCommunicationHistory(candidate.getCommunicationHistory());
        return candidateDto;
    }

    @Override
    public List<CandidateDto> convertToListPeopleDto(List<Candidate> people) {
        List<CandidateDto> candidateDtoList = new ArrayList<>();
        people.forEach((el) -> candidateDtoList.add(convertToPeopleDto(el)));
        return candidateDtoList;
    }

    @Override
    public KeywordDto convertToKeywordDto(Keyword keyword) {
        KeywordDto keywordDto = new KeywordDto();
        keywordDto.setId(keyword.getId());
        return keywordDto;
    }

    @Override
    public List<KeywordDto> convertToListKeywordDto(List<Keyword> keywords) {
        List<KeywordDto> list = new ArrayList<>();
        keywords.forEach((el) -> list.add(convertToKeywordDto(el)));
        return list;
    }

    @Override
    public CommunicationHistoryDto convertToCommunicationHistoryDto(CommunicationHistory communicationHistory) {
        CommunicationHistoryDto dto = new CommunicationHistoryDto();
        dto.setId(communicationHistory.getId());
        dto.setComment(communicationHistory.getComment());
        dto.setCreateDate(communicationHistory.getCreateDate());
        dto.setUpdateDate(communicationHistory.getUpdateDate());
        dto.setHuman(convertToPeopleDto(communicationHistory.getHuman()));

        return dto;
    }

    @Override
    public List<CommunicationHistoryDto> convertToListCommunicationHistoryDto(List<CommunicationHistory> communicationHistoryList) {
        List<CommunicationHistoryDto> dtoList = new ArrayList<>();
        communicationHistoryList.forEach(
                (p) -> dtoList.add(convertToCommunicationHistoryDto(p))
        );
        return dtoList;
    }
}
