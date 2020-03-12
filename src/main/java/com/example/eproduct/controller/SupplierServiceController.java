package com.example.eproduct.controller;

import com.example.eproduct.model.Supplier;
import com.example.eproduct.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SupplierServiceController {

    @Autowired
    private SupplierService supplierService;


    @GetMapping("/supplierform")
    public ModelAndView supplierform(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("supplier", new Supplier());
        modelAndView.setViewName("supplier/supplierform");
        return modelAndView;

    }

    @GetMapping("/getSupplier")
    public ModelAndView getSupplier(@RequestParam Integer id){
        Supplier supplier = supplierService.getSupplier(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("updateSupplier", supplier);
        modelAndView.setViewName("supplier/updateForm");
//
        return modelAndView;
    }
    @PostMapping("update/{id}")
    public ModelAndView updateSupplier(@PathVariable Integer id, @ModelAttribute Supplier supplier){
        supplierService.updateSupplier(id, supplier);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/getallsuppliers");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteSupplier(@PathVariable Integer id){
        supplierService.deleteSupplier(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/getallsuppliers");
        return modelAndView;
    }

    @PostMapping("/newsupplier")
    public ModelAndView addNewSupplier(@ModelAttribute Supplier supplier){
        ModelAndView modelAndView = new ModelAndView();
        supplierService.addNewSupplier(supplier);
        modelAndView.setViewName("redirect:/getallsuppliers");
        return modelAndView;
    }



    @GetMapping("/getallsuppliers")
    public ModelAndView getAllSuppliers(){
        List<Supplier> allSuppliers = supplierService.getAllSuppliers();
        ModelAndView modelandView = new ModelAndView();
       modelandView.addObject("getAllSuppliers", allSuppliers);
       modelandView.setViewName("supplier/supplierlist");
       return modelandView;
    }


}
