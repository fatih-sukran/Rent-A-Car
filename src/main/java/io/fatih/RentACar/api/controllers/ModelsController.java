package io.fatih.RentACar.api.controllers;

import io.fatih.RentACar.business.abstracts.BrandService;
import io.fatih.RentACar.business.abstracts.ModelService;
import io.fatih.RentACar.business.requests.CreateBrandRequest;
import io.fatih.RentACar.business.requests.CreateModelRequest;
import io.fatih.RentACar.business.responses.BrandResponse;
import io.fatih.RentACar.business.responses.brands.GetAllBrandsResponse;
import io.fatih.RentACar.business.responses.models.GetAllModelsResponse;
import io.fatih.RentACar.entities.Brand;
import io.fatih.RentACar.entities.Model;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/models")
@RestController(value = "Models Controller")
public class ModelsController {

    private final ModelService modelService;
    private final BrandService brandService;

    @GetMapping("/getAll")
    public List<GetAllModelsResponse> getAllModels() {
        var models = modelService.getAll();
        var allModelsResponses = new ArrayList<GetAllModelsResponse>();

        for (var model : models) {
            var modelResponse = new GetAllModelsResponse();
            modelResponse.setId(model.getId());
            modelResponse.setName(model.getName());
            modelResponse.setBrandName(model.getBrand().getName());

            allModelsResponses.add(modelResponse);
        }

        return allModelsResponses;
    }

    @PostMapping("/add")
    public String add(@Valid CreateModelRequest request) {
        var model = new Model();
        var brand = brandService.getById(request.getBrandId());

        model.setName(request.getName());
        model.setBrand(brand);
        modelService.add(model);

        return "Model added successfully";
    }
}
