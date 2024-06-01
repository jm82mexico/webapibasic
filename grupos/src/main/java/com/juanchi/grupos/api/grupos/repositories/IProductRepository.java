package com.juanchi.grupos.api.grupos.repositories;


import org.springframework.data.repository.CrudRepository;
import com.juanchi.grupos.api.grupos.entities.Product;


public interface IProductRepository extends CrudRepository<Product, Long>{

    
}
