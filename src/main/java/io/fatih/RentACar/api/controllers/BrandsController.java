package io.fatih.RentACar.api.controllers;

import io.fatih.RentACar.business.abstracts.BrandService;
import io.fatih.RentACar.business.requests.CreateBrandRequest;
import io.fatih.RentACar.business.responses.brands.GetAllBrandsResponse;
import io.fatih.RentACar.core.utilities.mapper.BrandMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/brands")
@RestController(value = "Brands Controller")
public class BrandsController {

    private final BrandService brandService;
    @Autowired
    private final BrandMapper brandMapper;

    @GetMapping("/getAll")
    public GetAllBrandsResponse getAllBrands() {
        var response = new GetAllBrandsResponse();
        var brands = brandService.getAll();

        for (var brand : brands) {
            var brandResponse = brandMapper.map(brand);
            response.getBrands().add(brandResponse);
        }

        return response;
    }

    @PostMapping("/add")
    public String  add(@Valid CreateBrandRequest request) {
        var brand = brandMapper.map(request);
        brandService.add(brand);

        return "Brand added successfully";
    }
}
