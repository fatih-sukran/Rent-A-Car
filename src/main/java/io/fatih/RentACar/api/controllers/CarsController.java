package io.fatih.RentACar.api.controllers;

import io.fatih.RentACar.business.abstracts.BrandService;
import io.fatih.RentACar.business.abstracts.CarService;
import io.fatih.RentACar.business.abstracts.ModelService;
import io.fatih.RentACar.business.requests.CreateCarRequest;
import io.fatih.RentACar.business.requests.CreateModelRequest;
import io.fatih.RentACar.business.responses.cars.GetAllCarsResponse;
import io.fatih.RentACar.business.responses.models.GetAllModelsResponse;
import io.fatih.RentACar.core.utilities.mapper.CarMapper;
import io.fatih.RentACar.entities.Car;
import io.fatih.RentACar.entities.Model;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/cars")
@RestController(value = "Cars Controller")
public class CarsController {

    private final CarService carService;
    private final ModelService modelService;
    private final CarMapper carMapper;

    @GetMapping("/getAll")
    public List<GetAllCarsResponse> getAllCars() {
        var cars = carService.getAll();
        var allCarsResponses = new ArrayList<GetAllCarsResponse>();

        for (var car : cars) {
            var carResponse = carMapper.map(car);
            allCarsResponses.add(carResponse);
        }

        return allCarsResponses;
    }

    @PostMapping("/add")
    public String add(@Valid CreateCarRequest request) {
        var car = carMapper.map(request);
        carService.add(car);

        return "Car added successfully";
    }
}
