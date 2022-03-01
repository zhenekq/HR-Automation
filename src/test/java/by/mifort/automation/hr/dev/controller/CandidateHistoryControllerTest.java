package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.db.H2Database;
import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
import liquibase.pro.packaged.F;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class CandidateHistoryControllerTest {

    private final CandidateHistoryController historyController;
    private final CandidateController candidateController;
    private List<CommunicationHistory> histories;
    private final EntityConverter<CommunicationHistory, CommunicationHistoryDto> converter;

    @Autowired
    CandidateHistoryControllerTest(CandidateHistoryController historyController, CandidateController candidateController, EntityConverter<CommunicationHistory, CommunicationHistoryDto> converter) {
        this.historyController = historyController;
        this.candidateController = candidateController;
        this.converter = converter;
    }

    @BeforeEach
    void init(){
        H2Database.getInstance().initializeCandidates().forEach(candidateController::create);
        histories = H2Database.getInstance().initializeHistories();
        histories.forEach((p) -> historyController.createByCandidateId(p.getCandidate().getId(), p));
    }


    @Test
    @DisplayName("Get candidate's exists history_not_archived")
    void checkWhenCandidateExistsCommunicationHistory_ArchivedFalse() {
        List<CommunicationHistory> expected = new ArrayList<>(List.of(
                histories.get(0)
        ));
        List<CommunicationHistoryDto> actualHistories = historyController.getByCandidateId("yauheni_vozny",new FilterDto());
        List<CommunicationHistoryDto> expectedHistories = converter.convertToListEntityDto(expected);
        assertEquals(expectedHistories, actualHistories);
    }

    @Test
    @DisplayName("Check communication history of not founded candidate")
    void checkWhenCandidateDoNotExistsCommunicationHistory_ArchivedFalse(){
        assertThrows(EntityNotFoundException.class,
                () -> historyController.getByCandidateId(RandomString.make(), new FilterDto()),
                "Entity not found!");
    }

    @Test
    @DisplayName("Check empty history of exists candidate")
    void checkWhenCandidateExistsCommunicationHistoryDoNotExists_ArchivedFalse(){
        List<CommunicationHistoryDto> histories = historyController.getByCandidateId("empty_candidate", new FilterDto());
        assertEquals(histories, Collections.emptyList());
    }

    @Test
    @DisplayName("Get candidate's exists history_archived")
    void checkWhenCandidateExistsCommunicationHistory_ArchivedTrue(){
        List<CommunicationHistory> expected = new ArrayList<>(List.of(
                histories.get(5),
                histories.get(6)
        ));
        FilterDto filterDto = new FilterDto();
        filterDto.setIsArchived(Boolean.TRUE);
        List<CommunicationHistoryDto> actualHistory = historyController.getByCandidateId("yauheni_vozny",filterDto);
        List<CommunicationHistoryDto> expectedHistory = converter.convertToListEntityDto(expected);
        assertEquals(actualHistory, expectedHistory);
    }


    @Test
    @DisplayName("Create communication history with exists candidate")
    void checkWhenCommunicationHistoryCreate_CandidateExists() {
        CommunicationHistory createHistory = new CommunicationHistory(new Timestamp(RandomUtils.nextLong()),
                new Timestamp(RandomUtils.nextLong()), RandomString.make(), Boolean.FALSE, new Candidate("artem_skrebets"));
        CommunicationHistoryDto actualHistory = historyController.createByCandidateId("artem_skrebets", createHistory);
        CommunicationHistoryDto expectedHistory = converter.convertToEntityDto(createHistory);
        assertEquals(actualHistory, expectedHistory);
    }

    @Test
    @DisplayName("Create communication history with do not exists candidate")
    void checkWhenCommunicationHistoryCreate_CandidateDoNotExists() {
        String randomCandidate = RandomString.make();
        CommunicationHistory createHistory = new CommunicationHistory(new Timestamp(RandomUtils.nextLong()),
                new Timestamp(RandomUtils.nextLong()), RandomString.make(), Boolean.FALSE, new Candidate(randomCandidate));
        assertThrows(EntityNotFoundException.class,
                () -> historyController.createByCandidateId(randomCandidate, createHistory),
                "Candidate do not exists!");
    }

    @Test
    @DisplayName("Update exists candidate with connected history, with all fields")
    void checkWhenUpdateCommunicationHistory_CandidateNotNullTruth(){
        CommunicationHistory history = histories.get(0);
        history.setComment("newComment");
        history.setUpdateDate(new Timestamp(RandomUtils.nextLong()));
        history.setCreateDate(new Timestamp(RandomUtils.nextLong()));
        CommunicationHistoryDto actualHistory = converter.convertToEntityDto(history);
        CommunicationHistoryDto expectedHistory = historyController.updateByCandidateId("yauheni_vozny", actualHistory);
        assertEquals(actualHistory, expectedHistory);
    }

    @Test
    @DisplayName("Update exists candidate with connected history, with only one update field")
    void checkWhenUpdateCommunicationHistoryOneField_CandidateNotNullTruth(){
        CommunicationHistory history = histories.get(0);
        history.setComment("newComment");
        CommunicationHistoryDto actualHistory = converter.convertToEntityDto(history);
        CommunicationHistoryDto expectedHistory = historyController.updateByCandidateId("yauheni_vozny", actualHistory);
        assertEquals(actualHistory, expectedHistory);
    }

    @Test
    @DisplayName("Update exists candidate with not connected to candidate another history id, with all fields")
    void checkWhenUpdateCommunicationHistory_CandidateNotNullFake() {
        CommunicationHistory history = histories.get(1);
        history.setComment("newComment");
        history.setUpdateDate(new Timestamp(RandomUtils.nextLong()));
        history.setCreateDate(new Timestamp(RandomUtils.nextLong()));
        CommunicationHistoryDto actualHistory = converter.convertToEntityDto(history);
        assertThrows(EntityNotFoundException.class,
                () -> historyController.updateByCandidateId("yauheni_vozny", actualHistory),
                "Communication history not found!");
    }

    @Test
    @DisplayName("Update do not exists candidate with exists history that connected to other candidate")
    void checkWhenUpdateCommunicationHistory_CandidateDoNotExists() {
        CommunicationHistory history = histories.get(0);
        history.setComment("newComment");
        history.setUpdateDate(new Timestamp(RandomUtils.nextLong()));
        history.setCreateDate(new Timestamp(RandomUtils.nextLong()));
        CommunicationHistoryDto actualHistory = converter.convertToEntityDto(history);
        String doNotExistsCandidateId = RandomString.make();
        assertThrows(EntityNotFoundException.class,
                () -> historyController.updateByCandidateId(doNotExistsCandidateId, actualHistory),
                "Communication history not found!");
    }

    @Test
    @DisplayName("Archive exists candidate and connected to him history")
    void checkArchiveCommunicationHistory_CandidateExists(){
        CommunicationHistory expectedHistory = histories.get(0);
        expectedHistory.setArchived(Boolean.TRUE);
        String candidateId = "yauheni_vozny";
        CommunicationHistoryDto actualHistory = historyController.archiveHistoryWithCandidate(candidateId, expectedHistory.getId());
        assertEquals(expectedHistory.getArchived(), actualHistory.getArchived());
    }

    @Test
    @DisplayName("Archive exists candidate and not connected to him history")
    void checkArchiveCommunicationHistoryFake_CandidateExists(){
        CommunicationHistory expectedHistory = histories.get(1);
        String candidateId = "yauheni_vozny";
        assertThrows(EntityNotFoundException.class,
                () -> historyController.archiveHistoryWithCandidate(candidateId, expectedHistory.getId()),
                "Communication history not found!");
    }

    @Test
    @DisplayName("Archive do not exists candidate and not connected to him history")
    void checkArchiveCommunicationHistoryFake_CandidateFake(){
        CommunicationHistory expectedHistory = histories.get(1);
        String candidateId = RandomString.make();
        assertThrows(EntityNotFoundException.class,
                () -> historyController.archiveHistoryWithCandidate(candidateId, expectedHistory.getId()),
                "Communication history not found!");
    }



}