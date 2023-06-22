package com.challange.challange;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/customers")

// Metotları çalıştırmak için gerekli komut her metot için farklı olup altında yazmakta
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;
    }

    @GetMapping
    List<Customer> customers(){
        return customerRepository.findAll();
        //müşteri tablosundaki herşeyi listeler
        //curl localhost:8080/customers
        
    }

    @GetMapping("/{id}")
    Customer byId(@PathVariable long id){
        return customerRepository.findOne(id);
        //id araması yapar ve mevcut id ye sahip olanın bütün özelliklerini listeler
        //curl localhost:8080/customers/2
    }
    @PostMapping
    Customer save(Customer customer){
        return customerRepository.save(customer);
        //müşlteri tablosuna yeni bir müşteri oluiturur
        //curl localhost:8080/customers -d"name=Nusret&age=22"

    }
    @DeleteMapping("/{customer}")
    void delete(@PathVariable Customer customer) {
        customerRepository.delete(customer);
        //müşteri tablosundan bir müşteri siler
        //curl -XDELETE localhost:8080/customers/2

    }
    @GetMapping("/search")
    List<Customer> searchByAge(@RequestParam int age) {
        return customerRepository.findByAge(age);
        //parantez içinde belirtilen değere göra arama yapar
        // ve o değere sahip olanları listeler
        // mesela burda " curl localhost:8080/customers/search?age=22 "
        // komutu verirsek müştreri tablosunda yaşı 22 olan kişileri listeler
        //curl localhost:8080/customers/search?age=22
    }


}
