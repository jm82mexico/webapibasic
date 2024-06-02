package com.juanchi.grupos.api.grupos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanchi.grupos.api.grupos.entities.Product;
import com.juanchi.grupos.api.grupos.repositories.IProductRepository;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        
        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        
        return repository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOptional = repository.findById(id);
        if(productOptional.isPresent()) {
            Product productdb = productOptional.orElseThrow();
            productdb.setName(product.getName());
            productdb.setPrice(product.getPrice());
            productdb.setDescription(product.getDescription());
            return Optional.of(repository.save(productdb));
        }
        return productOptional;
    }
    
    @Transactional
    @Override
    public Optional<Product> delete(Product product) {
        
        Optional<Product> productOptional = repository.findById(product.getId());
        productOptional.ifPresent(productdb ->{
            repository.delete(productdb);
        });
        return productOptional;
    }

}
