package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.CandidateDto;
import by.mifort.automation.hr.dev.dto.FilterDto;
import by.mifort.automation.hr.dev.entity.Candidate;
import by.mifort.automation.hr.dev.util.converter.EntityConverter;
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
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class CandidateControllerTest {

    private final CandidateController controller;
    private final EntityConverter<Candidate, CandidateDto> converter;
    private List<Candidate> candidates;

    @Autowired
    public CandidateControllerTest(CandidateController controller, EntityConverter<Candidate, CandidateDto> converter) {
        this.controller = controller;
        this.converter = converter;
    }

    @BeforeEach
    void init() {
        this.candidates = Arrays.asList(
                new Candidate("artem_skrebets", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("ilya_shvaibovich", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("stas_gutsko", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("timofey_yakimchuk", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("uliana_fomina", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("vladimir_zelmanchuk", new Timestamp(RandomUtils.nextLong()), RandomString.make()),
                new Candidate("yauheni_vozny", new Timestamp(RandomUtils.nextLong()), RandomString.make())
        );
        candidates.forEach(controller::create);
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
        List<CandidateDto> expectedCandidates = converter.convertToListEntityDto(this.candidates.subList(0, 3));
        assertEquals(actualCandidates, expectedCandidates);
    }

    @Test
    @DisplayName("Check exists candidate by id")
    void checkExistsCandidateByIdExpected_NotNull() {
        String expectedCandidateId = candidates.get(2).getId();
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
    void create() {
    }

    @Test
    void addKeywords() {
    }
}