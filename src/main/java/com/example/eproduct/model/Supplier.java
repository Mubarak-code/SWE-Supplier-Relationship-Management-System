package com.example.eproduct.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supplier {
//    supplierId:int, supplierNumber:int,  name:String, contactPhoneNumber:String

    @Id
    @GeneratedValue
    private Integer supplierId;
    private Integer supplierNumber;
    private  String name;
    private String contactPhoneNumber;

    public Supplier (){

    }

//    public Supplier(Integer supplierId, Integer supplierNumber, String name, String contactPhoneNumber) {
//        this.supplierId = supplierId;
//        this.supplierNumber = supplierNumber;
//        this.name = name;
//        this.contactPhoneNumber = contactPhoneNumber;
//    }

    public Supplier(Integer supplierNumber, String name, String contactPhoneNumber) {
        this.supplierNumber = supplierNumber;
        this.name = name;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(Integer supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }
}
