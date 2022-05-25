package com.delivery.drones.domain.drone;

import com.delivery.drones.domain.drone.enums.DroneState;
import com.delivery.drones.domain.drone.enums.DroneType;
import com.delivery.drones.domain.identifiers.SerialNumber;

public class Drone implements DroneI {

    /*
    * Properties Section
    * */
    private final SerialNumber serialNumber;

    private DroneType type;

    private Integer batteryCapacity;

    private Double batteryLevel = 1.0;

    private DroneState state = DroneState.IDLE;

    public Drone(SerialNumber serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Drone(SerialNumber serialNumber, DroneType type, Integer batteryCapacity){
        this.serialNumber = serialNumber;
        this.type = type;
        this.batteryCapacity = batteryCapacity;
    }

    /*
    * Methods Section
    * */
    public SerialNumber getSerialNumber() {
        return serialNumber;
    }

    public DroneType getType() {
        return type;
    }

    public void setType(DroneType type) {
        this.type = type;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public Double getWeightLimit() {
        if(type == null) return 0.0;
        return type.getWeightLimit();
    }

    @Override
    public Double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public DroneState getState() {
        return state;
    }

    public void setState(DroneState state) {
        this.state = state;
    }
}
