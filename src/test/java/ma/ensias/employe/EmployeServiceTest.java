package ma.ensias.employe;

import ma.ensias.employe.entite.Employe;
import ma.ensias.employe.reponse.EmployeReponse;
import ma.ensias.employe.repository.EmployeRepo;
import ma.ensias.employe.service.EmployeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeServiceTest {

    @Autowired
    private EmployeService employeService;

    @Autowired
    private EmployeRepo employeRepo;

    private int savedId;

    @BeforeEach
    void setUp() {
        employeRepo.deleteAll();
        Employe emp = new Employe(0, "Benali", 25);
        Employe saved = employeRepo.save(emp);
        savedId = saved.getId();
    }

    @Test
    void testGetEmployeById() {
        EmployeReponse response = employeService.getEmployeById(savedId);
        assertNotNull(response);
        assertEquals(savedId, response.getId());
        assertEquals("Benali", response.getName());
        assertEquals(25, response.getAge());
    }

    @Test
    void testGetEmployeById_NotFound() {
        EmployeReponse response = employeService.getEmployeById(99999);
        assertNull(response);
    }
}
