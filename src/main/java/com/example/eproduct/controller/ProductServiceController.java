package com.example.eproduct.controller;

import com.example.eproduct.model.Product;
import com.example.eproduct.model.Supplier;
import com.example.eproduct.service.ProductService;
import com.example.eproduct.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@RestController
public class ProductServiceController {
    @Autowired
    private ProductService productService;
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/productform")
    public ModelAndView getProductForm(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> allSupplier = supplierService.getAllSuppliers();
        modelAndView.addObject("newProduct", new Product());
        modelAndView.addObject("allSuppliers", allSupplier);
        modelAndView.setViewName("product/productform");

        return modelAndView;
    }

    @GetMapping("/allproduct")
    public ModelAndView getAllProduct(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> allProduct = productService.getAllProduct();
        List<Supplier> allSupplier = supplierService.getAllSuppliers();
        modelAndView.addObject("allProduct", allProduct);
        modelAndView.addObject("allSupplier", allSupplier);
        modelAndView.setViewName("product/productlist");
        return modelAndView;
    }

    @PostMapping("/newproduct")
    public ModelAndView newProduct(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView();
        productService.newProduct(product);
        modelAndView.setViewName("supplier/success");
        return  modelAndView;
    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable Long id, Product product){

        productService.updateProduct(id,product);
    }
}
