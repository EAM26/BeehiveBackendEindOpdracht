package nl.beehive.beehivebackendeindopdracht.services;

import nl.beehive.beehivebackendeindopdracht.dtos.input.EmployeeInputDto;
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

    public Long createEmployee(EmployeeInputDto employeeInputDto) {
        Employee employee = convertDtoToEntity(employeeInputDto);
        this.employeeRepository.save(employee);
        return employee.getId();
    }

    public void updateEmployee(Long id, EmployeeInputDto employeeInputDto) throws Exception {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new Exception());
        this.checkAndUpdate(employee, employeeInputDto);
        this.employeeRepository.save(employee);
    }

    private EmployeeOutputDto convertEntityToDto(Employee employee) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(employee, EmployeeOutputDto.class);
    }

    private Employee convertDtoToEntity(EmployeeInputDto employeeInputDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(employeeInputDto, Employee.class);
    }


    private Employee checkAndUpdate(Employee employee, EmployeeInputDto employeeInputDto) {
        if(employeeInputDto.firstName != null) {
            employee.setFirstName(employeeInputDto.firstName);
        }
        return employee;
    }
}
