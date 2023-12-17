package io.fatih.RentACar.business.responses.models;

import lombok.Data;

@Data
public class GetAllModelsResponse {
    private long id;
    private String name;
    private String brandName;
}
