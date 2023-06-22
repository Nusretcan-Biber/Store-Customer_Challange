package com.challange.challange;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/Store_log")
public class StoreController {

    private final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository){

        this.storeRepository = storeRepository;
    }
    
    @GetMapping
    List<Store> store(){
        return storeRepository.findAll();
        // burda store tablosundakileri listeler
        //curl localhost:8080/Store_log
        
    }

    @GetMapping("/{id}")
    Store byId(@PathVariable long id){
        return storeRepository.findOne(id);
        //store tablosunda bahsettiğimiz fatura numarasına göre -yani id- sıralar ve o alışverişi listeler
        //curl localhost:8080/Store_log/2
    }

    @PostMapping
    Store save(Store store){
        return storeRepository.save(store);
        //store tablosuna yeni bir alışveriş listeler
        //curl localhost:8080/Store_log -d"name=Nusret&age=22"
    }

    @DeleteMapping("/store")
    void delete (@PathVariable Store store){
        storeRepository.delete(store);
        //store tablosundan bir alışveriş siler
        //curl -XDELETE localhost:8080/Store_log/1
    }

    @GetMapping("/search")
    List<Customer> searchByCustomer_name(@RequestParam String customer_name){
        return storeRepository.findByCustomer_name(customer_name);
        // store tablosundaki aynı customer_name'e sahip alışverişleri listeler
        //curl localhost:8080/Store_log/search?customer_name=Nusret
        
    }





}
