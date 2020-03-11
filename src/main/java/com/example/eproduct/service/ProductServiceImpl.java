package com.example.eproduct.service;

import com.example.eproduct.model.Product;
import com.example.eproduct.model.Supplier;
import com.example.eproduct.repository.ProductRepository;
import com.example.eproduct.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepo;
    private SupplierRepository supplierRepo;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepo, SupplierRepository supplierRepo){
        this.productRepo = productRepo;
        this.supplierRepo = supplierRepo;

    }


    @Override
    public void newProduct(Product product) {

        productRepo.save(product);

    }

    @Override
    public List<Product> getAllProduct() {

        return productRepo.findAll();
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Product p = productRepo.findById(id).get();
        p.setName(product.getName());
        p.setDateSupplied(product.getDateSupplied());
        p.setProductNumber(product.getProductNumber());
        p.setUnitPrice(product.getUnitPrice());
        p.setQuantityInStock(product.getQuantityInStock());
        p.setSupplier(product.getSupplier());


        productRepo.save(p);


    }
}
