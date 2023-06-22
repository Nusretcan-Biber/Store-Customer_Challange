package com.challange.challange;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
//Getter Setter metotlarını tek tek yazmamak için ekledim
@Entity
//Sınıf ile veritabanımızdaki tabloyu birleştirir
public class Store {
    @Id
    @GeneratedValue
    //burda id nin bir primary key olduğu 
    //ve @GeneratedValue ile de oromatik sıralı değer almasını sağlıyor
    //burda id olarak belirlediğim değer satış başı verilen benzersiz bir fatura numarası 
    
    private long id;
    private String product;
    private String customer_name;

   // Store(){
        public Store(String customer_name, String product) {

            this.customer_name = customer_name;
            this.product = product ;


            
        }

    }
    
    
//}
