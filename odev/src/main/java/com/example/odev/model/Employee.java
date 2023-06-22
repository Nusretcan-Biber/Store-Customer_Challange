package com.example.odev.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "employee_id")
    private Long id;
    @Column (name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;






}
