package com.delivery.drones.domain.drone.enums;

import com.delivery.drones.constants.Constants;

public enum DroneType {
    LIGHTWEIGHT("LightWeight", Constants.LIGHTWEIGHT_DRONE_WEIGHT_LIMIT),
    MIDDLEWEIGHT("MiddleWeight", Constants.MIDDLEWEIGHT_DRONE_WEIGHT_LIMIT),
    CRUISERWEIGHT("CruiserWeight", Constants.CRUISERWEIGHT_DRONE_WEIGHT_LIMIT),
    HEAVYWEIGHT("HeavyWeight", Constants.HEAVYWEIGHT_DRONE_WEIGHT_LIMIT);

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
