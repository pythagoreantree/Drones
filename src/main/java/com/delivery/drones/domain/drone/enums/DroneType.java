package com.delivery.drones.domain.drone.enums;

import com.delivery.drones.constants.Constants;

import static com.delivery.drones.constants.Constants.*;

public enum DroneType {
    lightweight("lightweight", LIGHTWEIGHT_DRONE_WEIGHT_LIMIT),
    middleweight("middleweight", MIDDLEWEIGHT_DRONE_WEIGHT_LIMIT),
    heavyweight("heavyweight", HEAVYWEIGHT_DRONE_WEIGHT_LIMIT);

    String typeName;

    Double capacity;

    DroneType(String name, Double limit) {
        this.typeName = name;
        this.capacity = limit;
    }

    public Double getCapacity() {
        return capacity;
    }
}
