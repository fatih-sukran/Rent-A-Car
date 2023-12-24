package io.fatih.RentACar.core.utilities.mapper;

import io.fatih.RentACar.business.requests.CreateBrandRequest;
import io.fatih.RentACar.business.responses.BrandResponse;
import io.fatih.RentACar.entities.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface BrandMapper {
    BrandResponse map(Brand brand);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "model", ignore = true)
    Brand map(CreateBrandRequest request);

}
