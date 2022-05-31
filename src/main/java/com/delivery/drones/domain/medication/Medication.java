package com.delivery.drones.domain.medication;

import com.delivery.drones.domain.identifiers.MedicationCode;

import javax.imageio.ImageIO;
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
public class Medication {

    private String name;

    private final Double weight;

    private final MedicationCode code;

    private String imagePath = "/images/no-image-icon-1.jpg";

    private BufferedImage image;

    public Medication(String name, MedicationCode code, double weight) {
        this.name = name;
        this.code = code;
        this.weight = weight;
    }

    //? I need an uploader for this image to set image path
//    public Medication(String name, MedicationCode code, double weight, String imagePath) {
//        this.name = name;
//        this.code = code;
//        this.weight = weight;
//        this.imagePath = imagePath;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public MedicationCode getCode() {
        return code;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
