package io.fatih.RentACar;

import io.fatih.RentACar.business.responses.errors.ErrorResponse;
import io.fatih.RentACar.core.utilities.exceptions.BusinessRulesException;
import io.fatih.RentACar.business.responses.errors.ValidationErrorResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@SpringBootApplication
public class RentACarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentACarApplication.class, args);
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorResponse  handleBusinessRulesException(BusinessRulesException ex) {
        var errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError(HttpStatus.BAD_REQUEST);

        return errorResponse;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
        var errorResponse = new ValidationErrorResponse();
        errorResponse.setMessage("Validation error");
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError(HttpStatus.BAD_REQUEST);

        for (var error : ex.getBindingResult().getFieldErrors()) {
            errorResponse.getValidationErrors().put(error.getField(), error.getDefaultMessage());
        }

        return errorResponse;
    }
}
