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

    @PostMapping("/newproduct")
    public ModelAndView newProduct(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView();
        productService.newProduct(product);
        modelAndView.setViewName("redirect:/allproduct");
        return  modelAndView;
    }

    @GetMapping("/getProduct")
    public ModelAndView getProduct(@RequestParam Long id){
        Product product = productService.getProduct(id);
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("updateProduct", product);
        modelAndView.addObject("allSuppliers", suppliers);
        modelAndView.setViewName("product/updateForm");
        return modelAndView;
    }

    @PostMapping("updateProduct/{id}")
    public ModelAndView updateProduct(@PathVariable Long id, @ModelAttribute Product product){
        productService.updateProduct(id, product);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allproduct");
        return modelAndView;
    }

    @GetMapping("/allproduct")
    public ModelAndView getAllProduct(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> allProduct = productService.getAllProduct();
        modelAndView.addObject("allProduct", allProduct);
        modelAndView.setViewName("product/productlist");
        return modelAndView;
    }

    @GetMapping("deleteProduct/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id){
        productService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/allproduct");
        return modelAndView;
    }



}
