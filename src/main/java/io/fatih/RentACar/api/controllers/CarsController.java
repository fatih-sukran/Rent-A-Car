package io.fatih.RentACar.api.controllers;

import io.fatih.RentACar.business.abstracts.CarService;
import io.fatih.RentACar.business.abstracts.ModelService;
import io.fatih.RentACar.business.requests.CreateCarRequest;
import io.fatih.RentACar.business.responses.cars.GetAllCarsResponse;
import io.fatih.RentACar.core.base.BaseControllers;
import io.fatih.RentACar.core.utilities.mapper.CarMapper;
import io.fatih.RentACar.entities.Car;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/cars")
@RestController(value = "Cars Controller")
public class CarsController extends BaseControllers<Car, CarService> {

    private final CarService carService;
    private final CarMapper carMapper;

    public CarsController(CarService carService, CarMapper carMapper) {
        super(carService);
        this.carService = carService;
        this.carMapper = carMapper;
    }

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
    public String add(@Valid @RequestBody CreateCarRequest request) {
        var car = carMapper.map(request);
        carService.add(car);

        return "Car added successfully";
    }
}
