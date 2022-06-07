package com.delivery.drones.services;

import com.delivery.drones.domain.drone.Drone;
import com.delivery.drones.domain.drone.enums.DroneState;
import com.delivery.drones.domain.medication.Medication;
import com.delivery.drones.exceptions.DronesOperationException;
import com.delivery.drones.repositories.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {

    @Autowired
    DronesService dronesService;

    @Autowired
    MedicationRepository medicationRepository;

    public Medication addMedication(String serialNumber, Medication medication) {
        Drone drone = dronesService.getDroneBySerialNumber(serialNumber).orElseThrow(
           () -> new DronesOperationException("Can't add medication to this drone. Drone with this " +
                   "serial number = " + serialNumber + " is not registered.")

        );

        if (drone.getWorkload() + medication.getWeight() > drone.getCapacity()){
            throw new DronesOperationException("Cannot add this item. The Drone is overloaded.");
        }

        if (drone.getBatteryLevel() <= 0.25){
            throw new DronesOperationException("Low battery. Cannot take more items.");
        }

        medication.setDroneId(drone.getId());
        Medication medicationReturned = medicationRepository.save(medication);
        if (drone.getState().equals(DroneState.IDLE)){
            drone.setState(DroneState.LOADING);
        }
        drone.addWorkload(medication.getWeight());
        if (drone.getWorkload() == drone.getCapacity()){
            drone.setState(DroneState.LOADED);
        }
        dronesService.saveDrone(drone);
        return medicationReturned;
    }
}
