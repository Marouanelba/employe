package ma.ensias.employe;

import ma.ensias.employe.entite.Employe;
import ma.ensias.employe.repository.EmployeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeRepo employeRepo;

    private int savedId;

    @BeforeEach
    void setUp() {
        employeRepo.deleteAll();
        Employe saved = employeRepo.save(new Employe(0, "Benali", 25));
        savedId = saved.getId();
    }

    @Test
    void testGetEmployeDetails() throws Exception {
        mockMvc.perform(get("/employes/" + savedId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(savedId))
                .andExpect(jsonPath("$.name").value("Benali"))
                .andExpect(jsonPath("$.age").value(25));
    }
}
