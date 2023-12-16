package io.fatih.RentACar.api.controllers;

import io.fatih.RentACar.business.abstracts.BrandService;
import io.fatih.RentACar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "Brand Controller")
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/getAllBrands")
    public List<Brand> getAllBrands() {
        return brandService.getAll();
    }
}
