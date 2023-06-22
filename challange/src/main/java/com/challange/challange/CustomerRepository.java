package com.challange.challange;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;




@Configuration
public class CustomerRepository {
@Bean
CommandLineRunner databasePopulation(CustomerRepository repository){
    return args -> {
        repository.save(new Customer ("Nusret", 22));
        repository.save(new Customer ("Can", 25));
        repository.save(new Customer ("Kutsal", 30));
        };
        //3 adet müşteri oluşturup daha sonra listelemek üzere değer verdim
        
    }

Customer save(Customer customer) {
    return null;
}

public List<Customer> findAll() {
    return null;
}

public Customer findOne(long id) {
    return null;
}

public void delete(Customer customer) {
}

public List<Customer> findByAge(int age) {
    return null;
}

}






    

