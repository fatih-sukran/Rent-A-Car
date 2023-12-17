package io.fatih.RentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateModelRequest {
    @NotBlank
    private String name;
    private long brandId;
}
