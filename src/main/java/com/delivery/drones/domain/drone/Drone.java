package com.delivery.drones.domain.drone;

import com.delivery.drones.domain.drone.enums.DroneState;
import com.delivery.drones.domain.drone.enums.DroneType;
import com.delivery.drones.domain.medication.Medication;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "drone",
        uniqueConstraints = {
            @UniqueConstraint(name="serial_number_unique_constraint", columnNames = "serial_number")
        }
)
@AllArgsConstructor
public class Drone implements DroneI {

    /*
    * Properties Section
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "serial_number", nullable = false, updatable = false)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, updatable = false)
    private DroneType type;

    @Transient
    private Double capacity;

    @Column(name = "workload")
    private Double workload;

    @Column(name = "battery_capacity", nullable = false, updatable = false)
    private Integer batteryCapacity;

    @Column(name = "battery_level")
    private Double batteryLevel = 1.0;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private DroneState state = DroneState.IDLE;

    @OneToMany(mappedBy = "droneId", fetch = FetchType.LAZY)
    private List<Medication> medications;
    /*
    * Constructors
    * */
    public Drone(String serialNumber, String type, Integer batteryCapacity){
        this.serialNumber = serialNumber;
        this.type = DroneType.valueOf(type);
        this.batteryCapacity = batteryCapacity;
    }

    public Drone() {

    }

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

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DroneType getType() {
        return type;
    }

    public void setType(DroneType type) {
        this.type = type;
    }

    public Double getCapacity() {
        if(type == null) return 0.0;
        return type.getCapacity();
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getWorkload() {
        return workload;
    }

    public void setWorkload(Double workload) {
        this.workload = workload;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
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

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }
}
