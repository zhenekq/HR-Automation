//package by.mifort.automation.hr.dev.controller;
//
//import by.mifort.automation.hr.dev.db.H2Database;
//import by.mifort.automation.hr.dev.dto.CandidateUpdateDto;
//import by.mifort.automation.hr.dev.entity.CandidateUpdate;
//import by.mifort.automation.hr.dev.util.converter.EntityConverter;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@TestPropertySource(locations = "classpath:application-test.properties")
//class CandidateUpdatesControllerTest {
//
//    private final CandidateUpdatesController controller;
//    private final CandidateController candidateController;
//    private List<CandidateUpdate> updates = new ArrayList<>();
//    private final EntityConverter<CandidateUpdate, CandidateUpdateDto> converter;
//    private final H2Database h2Database = H2Database.getInstance();
//
//    @Autowired
//    CandidateUpdatesControllerTest(CandidateUpdatesController controller, CandidateController candidateController, EntityConverter<CandidateUpdate, CandidateUpdateDto> converter) {
//        this.controller = controller;
//        this.candidateController = candidateController;
//        this.converter = converter;
//    }
//
//    @BeforeEach
//    void init() {
//        updates = h2Database.initializeCandidateUpdates();
//        h2Database.initializeCandidates().forEach(candidateController::create);
//        updates.forEach((p) -> controller.create(p.getCandidate().getId(), p));
//    }
//
//    @Test
//    @DisplayName("Get exists candidate with exists updates")
//    void checkCandidateUpdateExists_CandidateExists(){
//        List<CandidateUpdateDto> expectedUpdates = converter.convertToListEntityDto(
//                List.of(updates.get(0), updates.get(5))
//        );
//        List<CandidateUpdateDto> actualUpdates = controller.getByCandidateId("yauheni_vozny");
//
//        assertEquals(expectedUpdates, actualUpdates);
//    }
//
//    @Test
//    void getByCandidateId() {
//    }
//
//    @Test
//    void create() {
//    }
//}