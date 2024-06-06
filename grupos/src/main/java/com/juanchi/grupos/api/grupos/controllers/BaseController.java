package com.juanchi.grupos.api.grupos.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {
    protected ResponseEntity<?> validation(BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        response.put("errors", errors);

        return ResponseEntity.badRequest().body(response);
    }
}
