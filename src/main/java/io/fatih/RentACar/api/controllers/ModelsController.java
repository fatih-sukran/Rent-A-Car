package io.fatih.RentACar.api.controllers;

import io.fatih.RentACar.business.abstracts.ModelService;
import io.fatih.RentACar.business.requests.CreateModelRequest;
import io.fatih.RentACar.business.responses.models.GetAllModelsResponse;
import io.fatih.RentACar.core.utilities.mapper.ModelMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/models")
@RestController(value = "Models Controller")
public class ModelsController {

    private final ModelMapper modelMapper;
    private final ModelService modelService;

    @GetMapping("/getAll")
    public List<GetAllModelsResponse> getAllModels() {
        var models = modelService.getAll();
        var allModelsResponses = new ArrayList<GetAllModelsResponse>();

        for (var model : models) {
            var modelResponse = modelMapper.map(model);
            allModelsResponses.add(modelResponse);
        }

        return allModelsResponses;
    }

    @PostMapping("/add")
    public String add(@Valid @RequestBody CreateModelRequest request) {
        var model = modelMapper.map(request);
        modelService.add(model);

        return "Model added successfully";
    }
}
