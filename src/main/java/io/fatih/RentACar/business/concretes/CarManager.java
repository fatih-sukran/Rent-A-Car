package io.fatih.RentACar.business.concretes;

import io.fatih.RentACar.business.abstracts.CarService;
import io.fatih.RentACar.business.rules.CarBusinessRules;
import io.fatih.RentACar.entities.Car;
import io.fatih.RentACar.service.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final CarBusinessRules carBusinessRules;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(long id) {
        return carRepository.getReferenceById(id);
    }

    @Override
    public void add(Car car) {
        carBusinessRules.checkIfCarPlateExists(car.getPlate());
        carRepository.save(car);
    }

    @Override
    public void delete(long id) {
        carRepository.deleteById(id);
    }
}
