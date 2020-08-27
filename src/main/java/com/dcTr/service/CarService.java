package com.dcTr.service;


import com.dcTr.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    void createCar(Car car);

    void updateCar(Car car);

    List<Car> getAllCar();

    Car getCarById(Long id);
}
