///*
//package by.mifort.automation.hr.dev.controller;
//
//import by.mifort.automation.hr.dev.db.H2Database;
//import by.mifort.automation.hr.dev.dto.AttributeTypesDto;
//import by.mifort.automation.hr.dev.dto.CandidateAttributesDto;
//import by.mifort.automation.hr.dev.entity.AttributeTypes;
//import by.mifort.automation.hr.dev.entity.Candidate;
//import by.mifort.automation.hr.dev.entity.CandidateAttributes;
//import by.mifort.automation.hr.dev.util.converter.EntityConverter;
//import net.bytebuddy.utility.RandomString;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@TestPropertySource(locations = "classpath:application-test.properties")
//class CandidateAttributeControllerTest {
//
//    private final CandidateAttributeController controller;
//    private final CandidateController candidateController;
//    private final AttributeTypesController typesController;
//    private final EntityConverter<CandidateAttributes, CandidateAttributesDto> converter;
//
//    private final H2Database h2Database = H2Database.getInstance();
//    private List<CandidateAttributes> attributesList;
//
//    @Autowired
//    CandidateAttributeControllerTest(CandidateAttributeController controller, CandidateController candidateController, AttributeTypesController typesController, EntityConverter<CandidateAttributes, CandidateAttributesDto> converter) {
//        this.controller = controller;
//        this.candidateController = candidateController;
//        this.typesController = typesController;
//        this.converter = converter;
//    }
//
//    @BeforeEach
//    void init(){
//        h2Database.initializeCandidates().forEach(candidateController::create);
//        h2Database.initializeAttributeTypes().forEach(typesController::create);
//        attributesList = h2Database.initializeCandidateAttributes();
//        attributesList
//                .forEach((p) -> controller.createByCandidateId(p.getCandidate().getId(), p, p.getAttributeTypes().getId()));
//    }
//
//
//    @Test
//    @DisplayName("Check candidate attributes by identifier exists")
//    void checkCandidateAttributesById_ExistsCandidate() {
//        List<CandidateAttributes> attributes = List.of(
//                attributesList.get(0),
//                attributesList.get(5)
//        );
//        List<CandidateAttributesDto> actualAttributes = controller.getByCandidateId("yauheni_vozny");
//        List<CandidateAttributesDto> expectedAttributes = converter.convertToListEntityDto(attributes);
//
//        assertEquals(actualAttributes, expectedAttributes);
//    }
//
//    @Test
//    @DisplayName("Check candidate attributes by identifier exists not equals")
//    void checkCandidateAttributesById_ExistsCandidate_Fake() {
//        List<CandidateAttributes> attributes = List.of(
//                attributesList.get(1),
//                attributesList.get(3)
//        );
//        List<CandidateAttributesDto> actualAttributes = controller.getByCandidateId("yauheni_vozny");
//        List<CandidateAttributesDto> expectedAttributes = converter.convertToListEntityDto(attributes);
//
//        assertNotEquals(actualAttributes, expectedAttributes);
//    }
//
//    @Test
//    @DisplayName("Check candidate attributes by identifier exists not equals")
//    void checkCandidateAttributesById_NotExistsCandidate() {
//        String fakeIdentifier = RandomString.make();
//        assertThrows(EntityNotFoundException.class,
//                () -> controller.getByCandidateId(fakeIdentifier),
//                "Candidate not found!");
//    }
//
//    @Test
//    @DisplayName("Check candidate attributes by identifier exists but attribute not")
//    void checkCandidateAttributesById_CandidateExists_AttributesNot(){
//        String candidateId = "empty_candidate";
//        List<CandidateAttributesDto> actualAttributes = controller.getByCandidateId(candidateId);
//        assertEquals(actualAttributes, Collections.emptyList());
//    }
//
//    @Test
//    @DisplayName("Create candidate attribute by identifier exists and exists type")
//    void checkCandidateAttributeCreateById_CandidateExists_AttributeTypeExists(){
//        String existCandidateId = "yauheni_vozny";
//        Integer attributeType = 2;
//        CandidateAttributes createAttribute = h2Database.getCandidateAttributesWithRandomValues(existCandidateId, attributeType);
//        CandidateAttributesDto actualAttribute = controller.createByCandidateId(existCandidateId, createAttribute, attributeType);
//        CandidateAttributesDto expectedAttribute = converter.convertToEntityDto(createAttribute);
//
//        assertEquals(actualAttribute, expectedAttribute);
//    }
//
//    @Test
//    @DisplayName("Create candidate attribute by identifier not exists and exists type")
//    void checkCandidateAttributeCreateById_CandidateNotExists_AttributeTypeExists(){
//        String existCandidateId = RandomString.make();
//        Integer attributeType = 2;
//        CandidateAttributes createAttribute = h2Database.getCandidateAttributesWithRandomValues(existCandidateId, attributeType);
//        assertThrows(EntityNotFoundException.class,
//                () -> controller.createByCandidateId(existCandidateId, createAttribute, attributeType),
//                "Candidate not found!");
//    }
//
//    @Test
//    @DisplayName("Create candidate attribute by identifier not exists and not exists type")
//    void checkCandidateAttributeCreateById_CandidateNotExists_AttributeTypeNotExists(){
//        String existCandidateId = RandomString.make();
//        Integer attributeType = Integer.MAX_VALUE;
//        CandidateAttributes createAttribute = h2Database.getCandidateAttributesWithRandomValues(existCandidateId, attributeType);
//        assertThrows(EntityNotFoundException.class,
//                () -> controller.createByCandidateId(existCandidateId, createAttribute, attributeType),
//                "Attribute type not found!");
//    }
//
//    @Test
//    @DisplayName("Create candidate attribute by identifier not exists and not exists type")
//    void checkCandidateAttributeCreateById_CandidateNullableFields_AttributeTypeExists(){
//        String existCandidateId = "yauheni_vozny";
//        Integer attributeType = 1;
//        CandidateAttributes createAttribute = h2Database.getCandidateAttributesWithRandomValues(existCandidateId, attributeType);
//        createAttribute.setValue(null);
//        assertThrows(IllegalArgumentException.class,
//                () -> controller.createByCandidateId(existCandidateId, createAttribute, attributeType),
//                "Fields cannot be nullable");
//    }
//}*/
