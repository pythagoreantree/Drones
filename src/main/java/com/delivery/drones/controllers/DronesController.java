package com.delivery.drones.controllers;

import com.delivery.drones.domain.drone.Drone;
import com.delivery.drones.services.DronesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DronesController {

    @Autowired
    DronesService dronesService;

    @GetMapping("api/drones/getall")
    public List<Drone> getAllDrones(){
        return dronesService.getDrones();
    }

    @PostMapping("api/drones/registerDrone")
    public ResponseEntity<String> registerDrone(@RequestBody Drone drone){
        dronesService.addDrone(drone);
        return new ResponseEntity<>("Drone is registered", HttpStatus.OK);
    }
}
