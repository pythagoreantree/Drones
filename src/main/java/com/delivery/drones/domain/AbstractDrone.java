package com.delivery.drones.domain;

public abstract class AbstractDrone implements Drone {

    /*
    * Properties Section
    * */
    SerialNumber serialNumber;

    DroneState state = DroneState.IDLE;

    double batteryCapacity = 1.0;

    protected AbstractDrone(SerialNumber serialNumber) {
        this.serialNumber = serialNumber;
    }

    /*
    * Methods Section
    * */
    public SerialNumber getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(SerialNumber serialNumber) {
        this.serialNumber = serialNumber;
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
