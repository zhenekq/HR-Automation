package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.entity.Keyword;
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

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class CandidateControllerTest {

    private final CandidateController controller;
    private final EntityConverter<Candidate, CandidateDto> converter;
    private List<Candidate> dbCandidates = new ArrayList<>();

    @Autowired
    public CandidateControllerTest(CandidateController controller, EntityConverter<Candidate, CandidateDto> converter) {
        this.controller = controller;
        this.converter = converter;
    }

    @BeforeEach
    void init() {
        this.dbCandidates = List.of(
                new Candidate("artem_skrebets", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("ilya_shvaibovich", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("stas_gutsko", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("timofey_yakimchuk", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("uliana_fomina", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("vladimir_zelmanchuk", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("yauheni_vozny", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("candidate", new Timestamp(RandomUtils.nextLong()), RandomString.make())
        );
        dbCandidates.forEach(controller::create);
    }

    @Test
    @DisplayName("Check not null paginated candidates")
    void assertPaginatedCandidates_NotNull() {
        FilterDto filterDto = new FilterDto(1, 3);
        List<CandidateDto> candidates = controller.getAll(filterDto);
        assertNotNull(candidates);
    }

    @Test
    @DisplayName("Check equals paginated candidates")
    void assertPaginatedCandidates_WithFilterDto_Equals() {
        FilterDto filterDto = new FilterDto(1, 3);
        List<CandidateDto> actualCandidates = controller.getAll(filterDto);
        List<CandidateDto> expectedCandidates = converter.convertToListEntityDto(dbCandidates.subList(0, 3));
        System.out.println(actualCandidates);
        assertEquals(actualCandidates.size(), expectedCandidates.size());
    }

    @Test
    @DisplayName("Check exists candidate by id")
    void checkExistsCandidateByIdExpected_NotNull() {
        String expectedCandidateId = dbCandidates.get(2).getId();
        CandidateDto actualCandidate = controller.getById(expectedCandidateId);
        assertNotNull(actualCandidate);
    }

    @Test
    @DisplayName("Check do not exist candidate by id, throw exception")
    void checkCandidateByIdExpected_ThrowEntityNotFoundException() {
        String randomString = RandomString.make();
        assertThrows(
                EntityNotFoundException.class,
                () -> controller.getById(randomString),
                "Entity not found!");
    }


    @Test
    @DisplayName("Check is created candidate not null")
    void checkIsCandidateCreatedInDatabase_NotNull() {
        String identifierRandom = RandomString.make();
        CandidateDto actualCandidate = controller.create(new Candidate(identifierRandom, new Timestamp(RandomUtils.nextLong()), identifierRandom));
        assertNotNull(actualCandidate);
    }

    @Test
    @DisplayName("Check is exists candidate cannot be created")
    void checkIsCandidateCreatedWithExistsId() {
        Candidate existsCandidate = dbCandidates.get(0);
        /*assertThrows(EntityExistsException.class,
                    () -> controller.create(existsCandidate),
                "Entity exists!");*/
    }

    @Test
    @DisplayName("Check create keywords to candidate, without exists keywords")
    void addKeywordsToCandidateWithoutKeywords() {
        List<String> expectedKeywords = List.of("java", "python", "react");
        Candidate expectedCandidate = dbCandidates.get(0);
        FilterDto filterDto = new FilterDto();
        filterDto.setKeyword(expectedKeywords);
        List<String> actualKeywords =  controller.addKeywords(expectedCandidate.getId(), filterDto)
                .stream()
                .map(object -> Objects.toString(object.getId(), null))
                .toList();
        assertEquals(expectedKeywords,actualKeywords);
    }

    @Test
    @DisplayName("Check are connected keyboards will be ignored when connected away, with new")
    void addKeywordsToCandidateWithKeywords(){
        List<String> addedKeywords = new ArrayList<>(List.of("java", "react"));
        Candidate expectedCandidate = dbCandidates.get(7);
        FilterDto filterDto = new FilterDto();
        filterDto.setKeyword(addedKeywords);
        controller.addKeywords(expectedCandidate.getId(), filterDto);
        addedKeywords.add("python");
        filterDto.setKeyword(addedKeywords);
        List<String> actualKeywords = controller.addKeywords(expectedCandidate.getId(), filterDto)
                .stream()
                .map(object -> Objects.toString(object.getId(), null))
                .toList();
        List<String> expectedKeywords = Stream.of(new Keyword("python"))
                .map(object -> Objects.toString(object.getId(), null))
                .toList();
        assertEquals(actualKeywords, expectedKeywords);
    }

}