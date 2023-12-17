package io.fatih.RentACar.api.controllers;

import io.fatih.RentACar.business.abstracts.BrandService;
import io.fatih.RentACar.business.abstracts.CarService;
import io.fatih.RentACar.business.abstracts.ModelService;
import io.fatih.RentACar.business.requests.CreateCarRequest;
import io.fatih.RentACar.business.requests.CreateModelRequest;
import io.fatih.RentACar.business.responses.cars.GetAllCarsResponse;
import io.fatih.RentACar.business.responses.models.GetAllModelsResponse;
import io.fatih.RentACar.entities.Car;
import io.fatih.RentACar.entities.Model;
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

    @GetMapping("/getAll")
    public List<GetAllCarsResponse> getAllCars() {
        var cars = carService.getAll();
        var allCarsResponses = new ArrayList<GetAllCarsResponse>();

        for (var car : cars) {
            var carResponse = new GetAllCarsResponse();
            carResponse.setId(car.getId());
            carResponse.setPlate(car.getPlate());
            carResponse.setModelYear(car.getModelYear());
            carResponse.setKilometer(car.getKilometer());
            carResponse.setAvailable(car.isAvailable());
            carResponse.setDailyPrice(car.getDailyPrice());
            carResponse.setBrandName(car.getModel().getBrand().getName());
            carResponse.setModelName(car.getModel().getName());

            allCarsResponses.add(carResponse);
        }

        return allCarsResponses;
    }

    @PostMapping("/add")
    public String add(CreateCarRequest request) {
        var car = new Car();
        var model = modelService.getById(request.getModelId());

        car.setPlate(request.getPlate());
        car.setModelYear(request.getModelYear());
        car.setKilometer(request.getKilometer());
        car.setDailyPrice(request.getDailyPrice());
        car.setAvailable(request.isAvailable());
        car.setModel(model);

        carService.add(car);

        return "Car added successfully";
    }
}
