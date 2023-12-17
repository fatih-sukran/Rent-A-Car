package io.fatih.RentACar.business.responses.errors;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {
    private int statusCode;
    private HttpStatus error;
    private String message;
}
