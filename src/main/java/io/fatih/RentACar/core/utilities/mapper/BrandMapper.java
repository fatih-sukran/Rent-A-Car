package io.fatih.RentACar.core.utilities.mapper;

import io.fatih.RentACar.business.requests.CreateBrandRequest;
import io.fatih.RentACar.business.responses.BrandResponse;
import io.fatih.RentACar.entities.Brand;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandResponse map(Brand brand);
    Brand map(CreateBrandRequest request);

}
