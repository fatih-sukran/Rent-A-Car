package io.fatih.RentACar.business.concretes;

import io.fatih.RentACar.business.abstracts.ModelService;
import io.fatih.RentACar.business.rules.ModelBusinessRules;
import io.fatih.RentACar.entities.Model;
import io.fatih.RentACar.service.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelBusinessRules modelBusinessRules;

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public Model getById(long id) {
        return modelRepository.getReferenceById(id);
    }

    @Override
    public void add(Model model) {
        modelBusinessRules.checkIfModelNameExists(model.getName());
        modelRepository.save(model);
    }
}
