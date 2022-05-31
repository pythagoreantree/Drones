package com.delivery.drones.domain.drone;

import com.delivery.drones.domain.drone.enums.DroneState;
import com.delivery.drones.domain.drone.enums.DroneType;
import com.delivery.drones.domain.identifiers.SerialNumber;

import javax.persistence.*;

@Entity
@Table
public class Drone implements DroneI {

    /*
    * Properties Section
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DroneType type;

    @Column(name = "battery_capacity")
    private Integer batteryCapacity;

    @Column(name = "battery_level")
    private Double batteryLevel = 1.0;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private DroneState state = DroneState.IDLE;

    public Drone(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Drone(String serialNumber, DroneType type, Integer batteryCapacity){
        this.serialNumber = serialNumber;
        this.type = type;
        this.batteryCapacity = batteryCapacity;
    }

    public Drone(String serialNumber, String droneType, Integer batteryCapacity) {
        this.serialNumber = serialNumber;
        this.type = DroneType.valueOf(droneType);
        this.batteryCapacity = batteryCapacity;
    }

    public Drone() {}

    /*
    * Methods Section
    * */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
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
