package com.example.odev.controller;

import com.example.odev.dto.EmployeeDtoForCreate;
import com.example.odev.model.Employee;
import com.example.odev.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getListEmployee() {
        return employeeService.employeeList();

    }

    @GetMapping("/{id}")
    public Employee getByEmployeeId(@PathVariable("id") Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDtoForCreate employeeDtoForCreate) {
        return employeeService.createEmployee(employeeDtoForCreate);


    }

    @PutMapping("/{id}")
    public Employee refleshEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return employeeService.uptadeEmployee(employee, id);


    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(  @PathVariable("id") Long id){
        employeeService.deleteEmployee(id);

    }

}
