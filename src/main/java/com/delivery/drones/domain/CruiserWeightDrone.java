package com.delivery.drones.domain;

import com.delivery.drones.constants.Constants;

public class CruiserWeightDrone extends AbstractDrone {

    protected CruiserWeightDrone(SerialNumber serialNumber) {
        super(serialNumber);
    }

    @Override
    public double getWeightLimit() {
        return Constants.CRUISERWEIGHT_DRONE_WEIGHT_LIMIT;
    }
}
