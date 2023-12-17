package io.fatih.RentACar.business.requests;

import lombok.Data;

@Data
public class CreateModelRequest {
    private String name;
    private long brandId;
}
