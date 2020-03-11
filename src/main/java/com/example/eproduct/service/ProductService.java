package com.example.eproduct.service;

import com.example.eproduct.model.Product;

import java.util.List;

public interface ProductService {

    void newProduct(Product product);
    List<Product> getAllProduct();
    void updateProduct(Long id, Product product);

}
