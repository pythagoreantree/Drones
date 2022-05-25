package com.delivery.drones.domain.drone;

import com.delivery.drones.domain.identifiers.SerialNumber;

public abstract class AbstractDrone implements Drone {

    /*
    * Properties Section
    * */
    public final SerialNumber serialNumber;

    public DroneState state = DroneState.IDLE;

    public double batteryCapacity = 1.0;

    protected AbstractDrone(SerialNumber serialNumber) {
        this.serialNumber = serialNumber;
    }

    /*
    * Methods Section
    * */
    public SerialNumber getSerialNumber() {
        return serialNumber;
    }

    public abstract double getWeightLimit();

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public DroneState getState() {
        return state;
    }

    public void setState(DroneState state) {
        this.state = state;
    }
}
