package io.fatih.RentACar.business.concretes;

import io.fatih.RentACar.business.abstracts.BrandService;
import io.fatih.RentACar.business.rules.BrandBusinessRules;
import io.fatih.RentACar.entities.Brand;
import io.fatih.RentACar.service.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandBusinessRules brandBusinessRules;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(long id) {
        return brandRepository.getReferenceById(id);
    }

    @Override
    public void add(Brand brand) {
        brandBusinessRules.checkIfBrandNameExists(brand.getName());
        brandRepository.save(brand);
    }

    @Override
    public void delete(long id) {
        brandRepository.deleteById(id);
    }
}
