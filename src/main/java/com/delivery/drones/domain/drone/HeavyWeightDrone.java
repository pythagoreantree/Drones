package com.delivery.drones.domain.drone;

import com.delivery.drones.constants.Constants;
import com.delivery.drones.domain.identifiers.SerialNumber;

public class HeavyWeightDrone extends AbstractDrone {

    protected HeavyWeightDrone(SerialNumber serialNumber) {
        super(serialNumber);
    }

    @Override
    public double getWeightLimit() {
        return Constants.HEAVYWEIGHT_DRONE_WEIGHT_LIMIT;
    }
}
