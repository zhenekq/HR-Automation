package by.mifort.automation.hr.dev.controller;

import by.mifort.automation.hr.dev.dto.CandidateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@ContextConfiguration
public class CandidateControllerTest {

    private final CandidateController controller;

    @Autowired
    public CandidateControllerTest(CandidateController controller) {
        this.controller = controller;
    }


    @Test
    @DisplayName("Test get all paginated candidates")
    public void getAll() {
    }

    @Test
    public void getById() {
        CandidateDto candidateDto = controller.getById("stas_gutsko");
        CandidateDto testCandidate = new CandidateDto();
        testCandidate.setStatus("employed");
        assertEquals(candidateDto.getStatus(), testCandidate.getStatus());

    }

    @Test
    public void create() {
    }

    @Test
    public void addKeywords() {
    }
}