package com.delivery.drones.domain;

import com.delivery.drones.Constants;

public class MiddleWeightDrone extends AbstractDrone {

    protected MiddleWeightDrone(SerialNumber serialNumber) {
        super(serialNumber);
    }

    @Override
    public double getWeightLimit() {
        return Constants.MIDDLEWEIGHT_DRONE_WEIGHT_LIMIT;
    }
}
