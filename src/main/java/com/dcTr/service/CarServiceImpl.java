package com.dcTr.service;

import com.dcTr.model.Car;
import com.dcTr.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return null;
    }
}
