package com.delivery.drones.domain;

import com.delivery.drones.constants.Constants;

public class HeavyWeightDrone extends AbstractDrone {

    protected HeavyWeightDrone(SerialNumber serialNumber) {
        super(serialNumber);
    }

    @Override
    public double getWeightLimit() {
        return Constants.HEAVYWEIGHT_DRONE_WEIGHT_LIMIT;
    }
}
