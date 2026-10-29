package ma.ensias.employe.service;

import ma.ensias.employe.entite.Employe;
import ma.ensias.employe.reponse.EmployeReponse;
import ma.ensias.employe.repository.EmployeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmployeService {

    @Autowired
    private EmployeRepo employeRepo;

    @Autowired
    private ModelMapper mapper;

    public EmployeReponse getEmployeById(int id) {
        Optional<Employe> employee = employeRepo.findById(id);
        if (employee.isPresent()) {
            return mapper.map(employee.get(), EmployeReponse.class);
        }
        return null;
    }
}
