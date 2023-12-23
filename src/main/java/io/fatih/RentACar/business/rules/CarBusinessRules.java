package io.fatih.RentACar.business.rules;

import io.fatih.RentACar.core.utilities.exceptions.BusinessRulesException;
import io.fatih.RentACar.service.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {

    private final CarRepository carRepository;

    public void checkIfCarPlateExists(String plate) {
        var exists = carRepository.existsByPlate(plate);

        if (exists) {
            throw new BusinessRulesException("Car plate '" + plate + "' already exists");
        }
    }
}
