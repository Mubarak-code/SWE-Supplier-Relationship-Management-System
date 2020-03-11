package com.example.eproduct.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomePageController {

    @GetMapping("/")
    public ModelAndView displayHomePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home/index");

        return modelAndView;

    }

}
