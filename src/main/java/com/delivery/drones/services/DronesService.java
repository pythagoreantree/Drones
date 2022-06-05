package com.delivery.drones.services;

import com.delivery.drones.domain.drone.Drone;
import com.delivery.drones.domain.identifiers.SerialNumber;
import com.delivery.drones.repositories.DronesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DronesService {

    @Autowired
    DronesRepository dronesRepo;

    public Drone addDrone(Drone drone) {

        //here check by serialNumber if exists

        if (!SerialNumber.isValid(drone.getSerialNumber())){
            //error length mush be less than 100 characters
        }
        dronesRepo.save(drone);
        return drone;
    }

    public List<Drone> getDrones() {
        List<Drone> dronesList = new ArrayList<Drone>();
//        dronesRepo.findAll().forEach(drone -> dronesList.add(drone));
        return dronesList;
//        return List.of(
//                new Drone("A1", "LIGHTWEIGHT", 15)
//        );
    }
}
