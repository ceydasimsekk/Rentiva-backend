package com.rentacar.rentacar.repository;
//Repository (veritabanıyla konuşan katman)
import com.rentacar.rentacar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> { //JpaRepository, bize CRUD (create-read-update-delete) işlemlerini hazır olarak sunar.
    // Gerekirse özel sorgular buraya yazılabilir
}
