package io.fatih.RentACar.business.rules;

import io.fatih.RentACar.core.utilities.exceptions.BusinessRulesException;
import io.fatih.RentACar.service.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private final BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) throws BusinessRulesException {
        var exists = brandRepository.existsByName(name);

        if (exists) {
            throw new BusinessRulesException("Brand name '" + name + "' already exists");
        }
    }
}
