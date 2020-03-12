package com.example.eproduct.service;


import com.example.eproduct.model.Product;
import com.example.eproduct.model.Supplier;
import com.example.eproduct.repository.SupplierRepository;
import com.example.eproduct.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void addNewSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public void updateSupplier(Integer id, Supplier supplier) {
//        Supplier s =  supplierRepository.findById(id).orElseGet(Supplier::new);
       Supplier s =  supplierRepository.findById(id).get();
       s.setSupplierId(supplier.getSupplierId());
       s.setName(supplier.getName());
       s.setSupplierNumber(supplier.getSupplierNumber());
       s.setContactPhoneNumber(supplier.getContactPhoneNumber());

       supplierRepository.save(s);

    }

    @Override
    public Supplier getSupplier(Integer id) {

        return supplierRepository.findById(id).get();

    }

    @Override
    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }

}

