package io.fatih.RentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateBrandRequest {
    @NotBlank
    @Size(min = 3, message = "Brand name must be at least 3 characters")
    private String name;
}
