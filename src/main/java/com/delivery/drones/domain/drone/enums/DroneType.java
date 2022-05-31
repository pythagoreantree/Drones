package com.delivery.drones.domain.drone.enums;

import com.delivery.drones.constants.Constants;

import static com.delivery.drones.constants.Constants.*;

public enum DroneType {
    LIGHTWEIGHT("LightWeight", LIGHTWEIGHT_DRONE_WEIGHT_LIMIT),
    MIDDLEWEIGHT("MiddleWeight", MIDDLEWEIGHT_DRONE_WEIGHT_LIMIT),
    CRUISERWEIGHT("CruiserWeight", CRUISERWEIGHT_DRONE_WEIGHT_LIMIT),
    HEAVYWEIGHT("HeavyWeight", HEAVYWEIGHT_DRONE_WEIGHT_LIMIT);

    String typeName;

    Double weightLimit;

    DroneType(String name, Double limit) {
        this.typeName = name;
        this.weightLimit = limit;
    }

    public Double getWeightLimit() {
        return weightLimit;
    }
}
