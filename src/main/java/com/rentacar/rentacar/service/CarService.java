package com.rentacar.rentacar.service;

import com.rentacar.rentacar.model.Car;
import com.rentacar.rentacar.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//Service(iş mantığı)
@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Optional<Car> getCarById(Long id) {
    return carRepository.findById(id);
}

public void deleteCar(Long id) {
    carRepository.deleteById(id);
}

}
//Burada veritabanıyla ilgili işlemlerimizi yöneteceğiz.