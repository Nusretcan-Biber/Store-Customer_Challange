package com.example.odev.service;

import com.example.odev.model.Company;
import com.example.odev.model.Employee;
import com.example.odev.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {


    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public Company getById(long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        Company company = optionalCompany.orElseThrow(() -> new RuntimeException("Company id :" + id));
        return company;

    }

    public Company creatCompany(Company company) {
        return companyRepository.save(company);


    }

    public Company uptadeCompany(Company company, Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isEmpty()) {
            throw new RuntimeException("Böyle bir şirket bulunmamaktadır:" + id);
        }
        Company oldCompany = getById(id);
        oldCompany.setCompanyName(company.getCompanyName());
        return oldCompany;
    }

    public List<Company> companyList() {
        return companyRepository.findAll();


    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);

    }
}


