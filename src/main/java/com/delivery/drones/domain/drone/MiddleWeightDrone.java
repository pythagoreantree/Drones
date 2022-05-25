package com.delivery.drones.domain.drone;

import com.delivery.drones.constants.Constants;
import com.delivery.drones.domain.identifiers.SerialNumber;

public class MiddleWeightDrone extends AbstractDrone {

    protected MiddleWeightDrone(SerialNumber serialNumber) {
        super(serialNumber);
    }

    @Override
    public double getWeightLimit() {
        return Constants.MIDDLEWEIGHT_DRONE_WEIGHT_LIMIT;
    }
}
