package com.example.odev.dto;

import com.example.odev.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDtoForCreate {


    private String firstName;

    private String lastName;

    private Long companyId;
}
