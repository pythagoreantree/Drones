package com.delivery.drones.domain.drone;

import com.delivery.drones.constants.Constants;
import com.delivery.drones.domain.identifiers.SerialNumber;

public class LightWeightDrone extends AbstractDrone {

    public LightWeightDrone(SerialNumber serialNumber) {
        super(serialNumber);
    }

    @Override
    public double getWeightLimit() {
        return Constants.LIGHTWEIGHT_DRONE_WEIGHT_LIMIT;
    }
}
