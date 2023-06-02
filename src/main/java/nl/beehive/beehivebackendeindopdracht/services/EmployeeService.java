package nl.beehive.beehivebackendeindopdracht.services;

import nl.beehive.beehivebackendeindopdracht.dtos.output.EmployeeOutputDto;
import nl.beehive.beehivebackendeindopdracht.models.Employee;
import nl.beehive.beehivebackendeindopdracht.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<EmployeeOutputDto>getAllEmployees() {
        List<EmployeeOutputDto> employeeOutputDtos = new ArrayList<>();
        for (Employee employee: this.employeeRepository.findAll()) {
            employeeOutputDtos.add(convertEntityToDto(employee));
        }
        return employeeOutputDtos;
    }

    public EmployeeOutputDto getEmployee(Long id) throws Exception {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new Exception());
        return this.convertEntityToDto(employee);
    }


    public EmployeeOutputDto convertEntityToDto(Employee employee) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(employee, EmployeeOutputDto.class);
    }
}
