package com.delivery.drones.repositories;

import com.delivery.drones.domain.drone.Drone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DronesRepository extends CrudRepository<Drone, Integer> {
}
