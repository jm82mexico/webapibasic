package com.juanchi.grupos.api.grupos.services;

import java.util.List;
import java.util.Optional;

import com.juanchi.grupos.api.grupos.entities.Product;

public interface IProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Optional<Product> delete(Product product);
}
