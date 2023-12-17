package io.fatih.RentACar.business.responses.cars;

import io.fatih.RentACar.entities.Brand;
import lombok.Data;

@Data
public class GetAllCarsResponse {
    private long id;
    private String plate;
    private int modelYear;
    private int kilometer;
    private boolean isAvailable;
    private double dailyPrice;
    private String brandName;
    private String modelName;
}
