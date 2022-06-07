package com.delivery.drones.services;

import com.delivery.drones.domain.drone.Drone;
import com.delivery.drones.domain.identifiers.SerialNumber;
import com.delivery.drones.domain.medication.Medication;
import com.delivery.drones.exceptions.DronesOperationException;
import com.delivery.drones.repositories.DronesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DronesService {

    @Autowired
    DronesRepository dronesRepository;

    public Drone addDrone(Drone drone) {

        if (dronesRepository.existsBySerialNumber(drone.getSerialNumber())){
            throw new DronesOperationException("Drone with this serial number = " +
                    drone.getSerialNumber() + " already exists.");
        }
        if (!SerialNumber.isValid(drone.getSerialNumber())){
            throw new DronesOperationException("Serial Number is too long (must be max 100 symbols).");
        }
        return dronesRepository.save(drone);
    }

    public boolean existsBySerialNumber(String serialNumber){
        return dronesRepository.existsBySerialNumber(serialNumber);
    }

    public List<Drone> getDrones() {
        return dronesRepository.findAllWithMedications();
    }

    public long numberOfDrones(){
        return dronesRepository.count();
    }

    public Optional<Drone> getDroneBySerialNumber(String serialNumber){
        return dronesRepository.findBySerialNumber(serialNumber);
    }

    public Drone getDroneBySerialNumberChecked(String serialNumber){
        Drone drone = getDroneBySerialNumber(serialNumber).orElseThrow(
                () -> new DronesOperationException("No drone found with serial number=" + serialNumber)
        );
        return drone;
    }

    public Double getBatteryLevelOfDrone(String serialNumber) {
        Drone drone = getDroneBySerialNumberChecked(serialNumber);
        return drone.getBatteryLevel();
    }

    public List<Medication> getMedications(String serialNumber) {
        Drone drone = getDroneBySerialNumberChecked(serialNumber);
        return drone.getMedications();
    }

    public List<Drone> getAvailableDrones() {
        return dronesRepository.findAllAvailableDrones();
    }

    public void saveDrone(Drone drone) {
        dronesRepository.save(drone);
    }
}
