package com.delivery.drones.repositories;

import com.delivery.drones.domain.drone.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DronesRepository extends JpaRepository<Drone, Integer> {

    @Query("SELECT d FROM Drone d LEFT JOIN FETCH d.medications where d.serialNumber = :serialNumber")
    Optional<Drone> findBySerialNumber(String serialNumber);

    boolean existsBySerialNumber(String serialNumber);

    @Query("SELECT d FROM Drone AS d WHERE d.batteryLevel > 0.25 AND d.workload <> d.capacity AND ( d.state = 'idle' or d.state = 'loading' )  ")
    List<Drone> findAllAvailableDrones();

    @Query("SELECT d FROM Drone d LEFT JOIN FETCH d.medications ORDER BY d.serialNumber")
    List<Drone> findAllWithMedications();
}
