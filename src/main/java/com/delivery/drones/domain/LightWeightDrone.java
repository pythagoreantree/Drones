package com.delivery.drones.domain;

import com.delivery.drones.constants.Constants;

public class LightWeightDrone extends AbstractDrone {

    public LightWeightDrone(SerialNumber serialNumber) {
        super(serialNumber);
    }

    @Override
    public double getWeightLimit() {
        return Constants.LIGHTWEIGHT_DRONE_WEIGHT_LIMIT;
    }
}
