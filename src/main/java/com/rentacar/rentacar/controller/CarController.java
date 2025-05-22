package com.rentacar.rentacar.controller;

import com.rentacar.rentacar.model.Car;
import com.rentacar.rentacar.service.CarService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//Controller (API uçları)
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @PutMapping("/{id}")
public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
    Optional<Car> carOptional = carService.getCarById(id);

    if (carOptional.isPresent()) {
        Car existingCar = carOptional.get();
        existingCar.setBrand(updatedCar.getBrand());
        existingCar.setModel(updatedCar.getModel());
        existingCar.setYear(updatedCar.getYear());
        existingCar.setPricePerDay(updatedCar.getPricePerDay());
        Car savedCar = carService.addCar(existingCar);
        return ResponseEntity.ok(savedCar);
    } else {
        return ResponseEntity.notFound().build();
    }
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
    if (carService.getCarById(id).isPresent()) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}
}