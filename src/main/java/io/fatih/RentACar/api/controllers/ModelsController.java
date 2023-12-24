package io.fatih.RentACar.api.controllers;

import io.fatih.RentACar.business.abstracts.ModelService;
import io.fatih.RentACar.business.requests.CreateModelRequest;
import io.fatih.RentACar.business.responses.models.GetAllModelsResponse;
import io.fatih.RentACar.core.base.BaseControllers;
import io.fatih.RentACar.core.utilities.mapper.ModelMapper;
import io.fatih.RentACar.entities.Model;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/models")
@RestController(value = "Models Controller")
public class ModelsController extends BaseControllers<Model, ModelService> {

    private final ModelService modelService;
    private final ModelMapper modelMapper;

    public ModelsController(ModelService service, ModelMapper modelMapper) {
        super(service);
        this.modelService = service;
        this.modelMapper = modelMapper;
    }

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
    public ResponseEntity<String> add(@Valid @RequestBody CreateModelRequest request) {
        var model = modelMapper.map(request);
        modelService.add(model);

        return new ResponseEntity<>("Model added successfully", HttpStatus.OK);
    }
}
