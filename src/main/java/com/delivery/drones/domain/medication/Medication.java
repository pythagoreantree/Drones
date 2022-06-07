package com.delivery.drones.domain.medication;

import com.delivery.drones.domain.drone.Drone;
import com.delivery.drones.domain.identifiers.MedicationCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
* Each Medication has:
- name (allowed only letters, numbers, ‘-‘, ‘_’);
- weight;
- code (allowed only upper case letters, underscore and numbers);
- image (picture of the medication case).
* */
@Entity
@Table( name = "medication",
        uniqueConstraints = {
                @UniqueConstraint(name="medication_code_unique_constraint", columnNames = "code")
        }
)
@AllArgsConstructor
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "image_url")
    private String imagePath = "/images/no-image-icon-1.jpg";

    @Column(name = "drone_id")
    private Integer droneId;

    public Medication(String name, String code, Double weight){
        this.name = name;
        this.code = code;
        this.weight = weight;
    }

    public Medication() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getDroneId() {
        return droneId;
    }

    public void setDroneId(Integer droneId) {
        this.droneId = droneId;
    }

    //    private BufferedImage image;

    /*public BufferedImage getImage() {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/

}
