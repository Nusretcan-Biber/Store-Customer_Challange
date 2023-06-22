package com.challange.challange;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
//Getter Setter metotlarını tek tek yazmamak için ekledim
@Entity
//Sınıf ile veritabanımızdaki tabloyu birleştirir

public class Customer {
    @Id
    @GeneratedValue
    //burda id nin bir primary key olduğu 
    //ve @GeneratedValue ile de oromatik sıralı değer almasını sağlıyor
    //burda id olarak belirlediğim değer müşterinin kimlik numarası
    private long id;
    private int age;
    private String name;

   // Customer(){
        public  Customer( String name, int age ) {
            this.name = name;
            this.age = age;
            
        }
    }


    



//}
