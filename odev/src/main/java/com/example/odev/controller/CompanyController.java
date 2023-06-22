package com.example.odev.controller;

import com.example.odev.model.Company;
import com.example.odev.model.Employee;
import com.example.odev.service.CompanyService;
import com.example.odev.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;


    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getListCompany() {
        return companyService.companyList();

    }

    @GetMapping("/{id}")
    public Company getByCompanyId(@PathVariable("id") Long id) {
        return companyService.getById(id);
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyService.creatCompany(company);


    }

    @PutMapping("/{id}")
    public Company refleshCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        return companyService.uptadeCompany(company, id);


    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);

    }

}

