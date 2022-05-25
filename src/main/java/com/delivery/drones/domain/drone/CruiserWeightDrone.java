package com.delivery.drones.domain.drone;

import com.delivery.drones.constants.Constants;
import com.delivery.drones.domain.identifiers.SerialNumber;

public class CruiserWeightDrone extends AbstractDrone {

    protected CruiserWeightDrone(SerialNumber serialNumber) {
        super(serialNumber);
    }

    @Override
    public double getWeightLimit() {
        return Constants.CRUISERWEIGHT_DRONE_WEIGHT_LIMIT;
    }
}
