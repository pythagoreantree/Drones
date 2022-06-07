package com.delivery.drones.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = "/")
    public String getRoot(){
        return sayHello();
    }

    @GetMapping(value = "/home")
    public String getHome(){
        return sayHello();
    }

    public String sayHello(){
        return "Welcome to Drones Home Page!";
    }
}
