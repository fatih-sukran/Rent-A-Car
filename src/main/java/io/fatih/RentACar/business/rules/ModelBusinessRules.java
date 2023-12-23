package io.fatih.RentACar.business.rules;

import io.fatih.RentACar.core.utilities.exceptions.BusinessRulesException;
import io.fatih.RentACar.service.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private final ModelRepository modelRepository;

    public void checkIfModelNameExists(String name) throws BusinessRulesException {
        var exists = modelRepository.existsByName(name);

        if (exists) {
            throw new BusinessRulesException("Model name '" + name + "' already exists");
        }
    }
}
