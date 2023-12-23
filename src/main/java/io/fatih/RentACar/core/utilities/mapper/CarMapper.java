package io.fatih.RentACar.core.utilities.mapper;

import io.fatih.RentACar.business.requests.CreateCarRequest;
import io.fatih.RentACar.business.responses.cars.GetAllCarsResponse;
import io.fatih.RentACar.entities.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    Car map(CreateCarRequest request);
    GetAllCarsResponse map(Car car);
}
