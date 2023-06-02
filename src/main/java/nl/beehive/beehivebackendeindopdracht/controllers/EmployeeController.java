package nl.beehive.beehivebackendeindopdracht.controllers;


import nl.beehive.beehivebackendeindopdracht.dtos.output.EmployeeOutputDto;
import nl.beehive.beehivebackendeindopdracht.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Iterable<EmployeeOutputDto>> getAllEmployees() {
        return new ResponseEntity<>(this.employeeService.getAllEmployees(), HttpStatus.OK);
    }
}
