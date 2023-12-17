package io.fatih.RentACar.business.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateCarRequest {
    @NotBlank
    private String plate;
    @Positive
    private int modelYear;
    @PositiveOrZero
    private int kilometer;
    private boolean isAvailable;
    @Positive
    private double dailyPrice;
    private long modelId;
}
