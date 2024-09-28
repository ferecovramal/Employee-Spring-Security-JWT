package net.javaguides.java_ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String,String> resourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SalaryException.class)
    public Map<String,String> salaryException(SalaryException ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WorkException.class)
    public Map<String,String> WorkException(WorkException ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CountryException.class)
    public Map<String,String> CountryException(CountryException ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailException.class)
    public Map<String,String> EmailException(EmailException ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LastnameException.class)
    public Map<String,String> LastnameException(LastnameException ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CityException.class)
    public Map<String,String> CityException(CityException ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(StreetException.class)
    public Map<String,String> StreetException(StreetException ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ZipCodeException.class)
    public Map<String,String> ZipCodeException(ZipCodeException ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
}
