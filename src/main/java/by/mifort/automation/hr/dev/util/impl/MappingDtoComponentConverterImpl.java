package by.mifort.automation.hr.dev.util.impl;

import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
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
        if (candidate.getKeywords() != null) {
            candidateDto.setKeywords(candidate.getKeywords());
        } else {
            candidateDto.setKeywords(new ArrayList<>());
        }
        if (candidate.getCommunicationHistory() != null) {
            candidateDto.setCommunicationHistory(candidate.getCommunicationHistory());
        } else {
            candidateDto.setCommunicationHistory(new ArrayList<>());
        }
        return candidateDto;
    }

    @Override
    public List<CandidateDto> convertToListPeopleDto(List<Candidate> people) {
        return people.stream()
                .map(this::convertToPeopleDto)
                .toList();
    }

    @Override
    public CommunicationHistoryDto convertToCommunicationHistoryDto(CommunicationHistory communicationHistory) {
        CommunicationHistoryDto dto = new CommunicationHistoryDto();
        dto.setId(communicationHistory.getId());
        dto.setComment(communicationHistory.getComment());
        dto.setCreateDate(communicationHistory.getCreateDate());
        dto.setUpdateDate(communicationHistory.getUpdateDate());

        return dto;
    }

    @Override
    public List<CommunicationHistoryDto> convertToListCommunicationHistoryDto(List<CommunicationHistory> communicationHistoryList) {
        return communicationHistoryList.stream()
                .map(this::convertToCommunicationHistoryDto)
                .toList();
    }
}
