package io.fatih.RentACar.core.utilities.mapper;

import io.fatih.RentACar.business.abstracts.BrandService;
import io.fatih.RentACar.business.requests.CreateModelRequest;
import io.fatih.RentACar.business.responses.models.GetAllModelsResponse;
import io.fatih.RentACar.entities.Model;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.*;

@Mapper(componentModel = SPRING)
public interface ModelMapper {

    @Mapping(target = "brand.id", source = "request.brandId")
    @Mapping(target = "brand.", ignore = true)
    Model map(CreateModelRequest request);

    @Mapping(target = "brandName", source = "brand.name")
    GetAllModelsResponse map(Model model);
}
