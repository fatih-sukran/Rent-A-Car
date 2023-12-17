package io.fatih.RentACar.business.requests;

import lombok.Data;

@Data
public class CreateCarRequest {
    private String plate;
    private int modelYear;
    private int kilometer;
    private boolean isAvailable;
    private double dailyPrice;
    private long modelId;
}
