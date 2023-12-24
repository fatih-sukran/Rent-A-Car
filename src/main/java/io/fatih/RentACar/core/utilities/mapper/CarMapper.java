package io.fatih.RentACar.core.utilities.mapper;

import io.fatih.RentACar.business.requests.CreateCarRequest;
import io.fatih.RentACar.business.responses.cars.GetAllCarsResponse;
import io.fatih.RentACar.entities.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CarMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "model.id", source = "request.modelId")
    Car map(CreateCarRequest request);

    @Mapping(target = "brandName", source = "model.brand.name")
    @Mapping(target = "modelName", source = "model.name")
    GetAllCarsResponse map(Car car);
}
