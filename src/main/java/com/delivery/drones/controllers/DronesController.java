package com.delivery.drones.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController("/Drones")
public class DronesController {


    @PostMapping(value = "/registerDrone")
    public @ResponseBody void registerDrone(@RequestParam String serialNumber,
                                            @RequestParam String type,
                                            @RequestParam Double batteryCapacity){

    }
}
