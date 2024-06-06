package com.juanchi.grupos.api.grupos.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.juanchi.grupos.api.grupos.entities.Product;


@Component
public class ProductValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
       return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "es obligatorio desde ProductValidation");

        if(product.getDescription() == null || product.getDescription().isEmpty()){
            errors.rejectValue("description", "", "es obligatorio desde ProductValidation");
        }

        if (product.getPrice() == null){
            errors.rejectValue("price", "", "es obligatorio desde ProductValidation");
        }else if(product.getPrice() < 500){
            errors.rejectValue("price", "", "no puede ser menor a 500 desde ProductValidation");
        }


    }

}
