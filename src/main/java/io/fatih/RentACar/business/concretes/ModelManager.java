package io.fatih.RentACar.business.concretes;

import io.fatih.RentACar.business.abstracts.ModelService;
import io.fatih.RentACar.entities.Model;
import io.fatih.RentACar.service.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public void add(Model model) {
        modelRepository.save(model);
    }
}
