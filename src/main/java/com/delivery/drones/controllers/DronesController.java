package com.delivery.drones.controllers;

import com.delivery.drones.domain.drone.Drone;
import com.delivery.drones.services.DronesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DronesController {

    @Autowired
    DronesService dronesService;

    @GetMapping("api/drones/getall")
    public List<Drone> getAllDrones(){
        return dronesService.getDrones();
    }

    @PostMapping("api/drones/registerDrone")
    public String registerDrone(@RequestBody Drone drone){
        dronesService.addDrone(drone);
        return "Drone is registered";
    }
}
