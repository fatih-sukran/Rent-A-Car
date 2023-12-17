package io.fatih.RentACar.api.controllers;

import io.fatih.RentACar.business.abstracts.BrandService;
import io.fatih.RentACar.business.requests.CreateBrandRequest;
import io.fatih.RentACar.business.responses.BrandResponse;
import io.fatih.RentACar.business.responses.brands.GetAllBrandsResponse;
import io.fatih.RentACar.entities.Brand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/brands")
@RestController(value = "Brands Controller")
public class BrandsController {

    private final BrandService brandService;

    @GetMapping("/getAll")
    public GetAllBrandsResponse getAllBrands() {
        var response = new GetAllBrandsResponse();
        var brands = brandService.getAll();

        for (var brand : brands) {
            var brandResponse = new BrandResponse();
            brandResponse.setId(brand.getId());
            brandResponse.setName(brand.getName());
            response.getBrands().add(brandResponse);
        }

        return response;
    }

    @PostMapping("/add")
    public String  add(@Valid CreateBrandRequest request) {
        var brand = new Brand();
        brand.setName(request.getName());
        brandService.add(brand);

        return "Brand added successfully";
    }
}
