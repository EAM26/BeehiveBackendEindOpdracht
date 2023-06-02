package nl.beehive.beehivebackendeindopdracht.controllers;


import nl.beehive.beehivebackendeindopdracht.dtos.input.EmployeeInputDto;
import nl.beehive.beehivebackendeindopdracht.dtos.output.EmployeeOutputDto;
import nl.beehive.beehivebackendeindopdracht.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeOutputDto> getEmployee(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeInputDto employeeInputDto) {
        Long createdId = this.employeeService.createEmployee(employeeInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + createdId).toUriString());
        return new ResponseEntity<>("Employee created with id: " + createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody EmployeeInputDto employeeInputDto) throws Exception {
        this.employeeService.updateEmployee(id, employeeInputDto);
        return new ResponseEntity<>("Updated", HttpStatus.ACCEPTED);
    }

}
