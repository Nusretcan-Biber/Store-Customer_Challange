package com.challange.challange;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Configuration
public class StoreRepository {

    @Bean
     CommandLineRunner databasePopulation(StoreRepository repository){
        return args -> {
            repository.save (new Store("Nusret", "Zippo"));
            repository.save (new Store("Hazal", "Lantern"));
            repository.save (new Store("Can", "handkerchief"));
        };
        //3 adet tablo satırı oluşturup daha sonra listelemek üzere değer verdim
     }

    Store save(Store store) {
        return null;
    }

    public List<Store> findAll() {
        return null;
    }

    public Store findOne(long id) {
        return null;
    }

    public void delete(Store store) {
    }

    public List<Customer> findByCustomer_name(String customer_name) {
        return null;
    }
    
}
