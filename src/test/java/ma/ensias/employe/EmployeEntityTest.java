package ma.ensias.employe;

import ma.ensias.employe.entite.Employe;
import ma.ensias.employe.reponse.EmployeReponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeEntityTest {

    @Test
    void testEmployeEntity() {
        Employe emp = new Employe();
        emp.setId(1);
        emp.setName("Alice");
        emp.setAge(30);

        assertEquals(1, emp.getId());
        assertEquals("Alice", emp.getName());
        assertEquals(30, emp.getAge());

        Employe emp2 = new Employe(2, "Bob", 35);
        assertEquals(2, emp2.getId());
        assertEquals("Bob", emp2.getName());
        assertEquals(35, emp2.getAge());
    }

    @Test
    void testEmployeReponse() {
        EmployeReponse rep = new EmployeReponse();
        rep.setId(1);
        rep.setName("Alice");
        rep.setAge(30);

        assertEquals(1, rep.getId());
        assertEquals("Alice", rep.getName());
        assertEquals(30, rep.getAge());

        EmployeReponse rep2 = new EmployeReponse(2, "Bob", 35);
        assertEquals(2, rep2.getId());
        assertEquals("Bob", rep2.getName());
        assertEquals(35, rep2.getAge());
    }
}
