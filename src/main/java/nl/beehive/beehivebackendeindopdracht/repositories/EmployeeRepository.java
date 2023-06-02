package nl.beehive.beehivebackendeindopdracht.repositories;

import nl.beehive.beehivebackendeindopdracht.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
