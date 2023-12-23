package io.fatih.RentACar.core.utilities.mapper;

import io.fatih.RentACar.business.requests.CreateBrandRequest;
import io.fatih.RentACar.business.requests.CreateModelRequest;
import io.fatih.RentACar.business.responses.models.GetAllModelsResponse;
import io.fatih.RentACar.entities.Model;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {
    Model map(CreateModelRequest request);
    GetAllModelsResponse map(Model model);
}
