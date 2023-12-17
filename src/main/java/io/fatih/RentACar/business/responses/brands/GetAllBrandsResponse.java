package io.fatih.RentACar.business.responses.brands;

import io.fatih.RentACar.business.responses.BrandResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetAllBrandsResponse {
    private List<BrandResponse> brands = new ArrayList<>();
}
