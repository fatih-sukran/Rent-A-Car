package io.fatih.RentACar.business.concretes;

import io.fatih.RentACar.business.abstracts.BrandService;
import io.fatih.RentACar.entities.Brand;
import io.fatih.RentACar.service.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public void add(Brand brand) {
        brandRepository.save(brand);
    }
}
