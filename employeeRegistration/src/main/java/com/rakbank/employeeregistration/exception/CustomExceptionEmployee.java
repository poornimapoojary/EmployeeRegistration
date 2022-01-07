package com.rakbank.employeeregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomExceptionEmployee extends Exception{
    public  CustomExceptionEmployee(String message){
        super(message);
    }
}
