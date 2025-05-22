package com.rentacar.rentacar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity //Bu sınıf bir veritabanı tablosu olacak demektir.
@Data      
@NoArgsConstructor
@AllArgsConstructor  //@Data, @NoArgsConstructor, @AllArgsConstructor Lombok sayesinde getter-setter-yapıcı metotları bizim yerimize oluşturur.
public class Car {

    @Id //@Id ve @GeneratedValue: Otomatik artan birincil anahtar (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private int year;
    private double pricePerDay;
    private String image;
}
