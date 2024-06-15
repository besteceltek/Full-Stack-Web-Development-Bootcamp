package com.beste.reactbackend.service.abstracts;

import com.beste.reactbackend.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product update(Long id, Product product);
    List<Product> findAll();
    Product findById(Long id);
    void delete(Long id);
}
