package io.fatih.RentACar.business.responses;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetAllBrandsResponse {
    private List<BrandResponse> brands = new ArrayList<>();
}
