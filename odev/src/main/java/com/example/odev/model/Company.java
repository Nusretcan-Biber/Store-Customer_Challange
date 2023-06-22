package com.example.odev.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name = "company_id")
    private Long id;
    @Column (name = "companyName")
    private String companyName;


}
