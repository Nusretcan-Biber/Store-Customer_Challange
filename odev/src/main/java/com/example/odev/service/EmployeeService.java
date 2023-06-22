package com.example.odev.service;

import com.example.odev.dto.EmployeeDtoForCreate;
import com.example.odev.model.Company;
import com.example.odev.model.Employee;
import com.example.odev.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;



    public List<Employee> employeeList(){
      return employeeRepository.findAll();


    }
    public Employee getById(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = optionalEmployee .orElseThrow(() -> new RuntimeException("Employee id :" + id));
        return employee;

    }

    /*public Employee creatEmployee(Employee employee) {
        Company company = companyService.getById(employee.getId());
        employee.setCompany(company);
        return employeeRepository.save(employee);

    }*/
    public Employee createEmployee(EmployeeDtoForCreate request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        Long companyId = request.getCompanyId();

        Company company = companyService.getById(companyId);

        if (company != null) {
            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setCompany(company);

            return employeeRepository.save(employee);
        } else {
            // Şirket bulunamadı, hata durumunu yönet
            // ...
            return null;
        }
    }
    public Employee uptadeEmployee(Employee employee, Long id){
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()){
            throw new RuntimeException("Böyle bir kullanıcı bulunmamaktadır:" + id);
        }
        Employee oldEmployee= getById(id);
        oldEmployee.setFirstName(employee.getFirstName());
        oldEmployee.setLastName(employee.getLastName());
        return employeeRepository.save(oldEmployee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);

    }
}
