package com.example.eproduct.service;

import com.example.eproduct.model.Supplier;

import java.util.List;

public interface SupplierService {

    void addNewSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    void updateSupplier(Integer id, Supplier supplier);
    Supplier getSupplier(Integer id);
    void deleteSupplier(Integer id);


}
