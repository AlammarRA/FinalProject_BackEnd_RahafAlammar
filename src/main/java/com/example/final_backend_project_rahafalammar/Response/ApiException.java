package com.example.final_backend_project_rahafalammar.Response;

public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }
}