package com.delivery.drones.repositories;

import com.delivery.drones.domain.drone.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DronesRepository extends JpaRepository<Drone, Integer> {
}
