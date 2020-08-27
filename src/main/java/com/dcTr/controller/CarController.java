package com.dcTr.controller;

import com.dcTr.model.Car;
import com.dcTr.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/cars/")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("showForm")
    public String showCarForm(Car car) {
        return "add-car";
    }

    @GetMapping("list")
    public String cars(Model model) {
        model.addAttribute(this.carRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addCar(@Validated Car car, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-car";
        }

        this.carRepository.save(car);
        return "redirect:list";
    }


    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable ("id") long id, Model model) {
        Car car = this.carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car  id : " + id));

        model.addAttribute( car);
        return "update-car";
    }

    @PostMapping("update/{id}")
    public String updateCar(@PathVariable("id") long id, Car car, BindingResult result, Model model) {
        if(result.hasErrors()) {
            car.setId(id);
            return "update-car";
        }

        // update student
        carRepository.save(car);

        // get all students ( with update)
        model.addAttribute(this.carRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable ("id") long id, Model model) {

        Car car = this.carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car id : " + id));

        this.carRepository.delete(car);
        model.addAttribute(this.carRepository.findAll());
        return "index";

    }
}