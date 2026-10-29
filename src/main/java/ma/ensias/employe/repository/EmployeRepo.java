package ma.ensias.employe.repository;

import ma.ensias.employe.entite.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Integer> {
}
