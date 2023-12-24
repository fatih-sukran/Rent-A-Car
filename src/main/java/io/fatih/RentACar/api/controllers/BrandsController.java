package io.fatih.RentACar.api.controllers;

import io.fatih.RentACar.business.abstracts.BrandService;
import io.fatih.RentACar.business.requests.CreateBrandRequest;
import io.fatih.RentACar.business.responses.brands.GetAllBrandsResponse;
import io.fatih.RentACar.core.base.BaseControllers;
import io.fatih.RentACar.core.utilities.mapper.BrandMapper;
import io.fatih.RentACar.entities.Brand;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@EqualsAndHashCode(callSuper = true)
@RequestMapping("/api/brands")
@RestController(value = "Brands Controller")
public class BrandsController extends BaseControllers<Brand, BrandService> {
    private final BrandService brandService;
    private final BrandMapper brandMapper;

    public BrandsController(BrandService brandService, BrandMapper brandMapper) {
        super(brandService);
        this.brandService = brandService;
        this.brandMapper = brandMapper;
    }

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
    public ResponseEntity<String> add(@Valid @RequestBody CreateBrandRequest request) {
        var brand = brandMapper.map(request);
        brandService.add(brand);

        return new ResponseEntity<>("Brand added successfully", HttpStatus.OK);
    }
}
