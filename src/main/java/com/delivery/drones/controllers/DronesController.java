package com.delivery.drones.controllers;

import com.delivery.drones.domain.drone.Drone;
import com.delivery.drones.domain.medication.Medication;
import com.delivery.drones.exceptions.DronesOperationException;
import com.delivery.drones.services.DronesService;

import java.util.ArrayList;
import java.util.List;

import com.delivery.drones.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/*
* The service should allow:
- registering a drone;
- loading a drone with medication items;
- checking loaded medication items for a given drone;
- checking available drones for loading;
- check drone battery level for a given drone;
* */
@RestController
public class DronesController {

    @Autowired
    DronesService dronesService;

    @Autowired
    MedicationService medicationService;

    @GetMapping("api/drones/getall")
    public ResponseEntity<List<Drone>> getAllDrones(){
        return ResponseEntity.ok(dronesService.getDrones());
    }

    @PostMapping("api/drones/addDrone")
    public ResponseEntity<String> addDrone(@RequestBody Drone drone){
        if(dronesService.numberOfDrones() < 10){
            Drone droneReturned = dronesService.addDrone(drone);
            return ResponseEntity.ok("Drone is registered with id = "+ droneReturned.getId());
        } else {
            throw new DronesOperationException("Too many Drones in the pool");
        }
    }

    @PostMapping("api/drones/{serialNumber}/addMedication")
    public ResponseEntity<String> addMedication(@PathVariable String serialNumber,
                                                @RequestBody Medication medication){
        Medication medicationReturned = medicationService.addMedication(serialNumber, medication);
        return ResponseEntity.ok("Medication is added with id=" + medicationReturned.getId());
    }

    @GetMapping("api/drones/{serialNumber}/getAllMedications")
    public ResponseEntity<List<Medication>> getAllMedications(@PathVariable String serialNumber){
        return ResponseEntity.ok(dronesService.getMedications(serialNumber));
    }

    @GetMapping("api/drones/getAvailableDrones")
    public ResponseEntity<List<Drone>> getAvailableDrones(){
        return ResponseEntity.ok(dronesService.getAvailableDrones());
    }

    @GetMapping("api/drones/{serialNumber}/checkBatteryLevel")
    public ResponseEntity<Double> checkBatteryLevel(@PathVariable String serialNumber){
        return ResponseEntity.ok(dronesService.getBatteryLevelOfDrone(serialNumber));
    }

}
