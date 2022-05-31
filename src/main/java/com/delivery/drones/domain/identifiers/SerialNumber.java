package com.delivery.drones.domain.identifiers;

import static com.delivery.drones.constants.Constants.MAX_SERIAL_NUMBER_LENGTH;

public class SerialNumber {

    public static boolean isValid(String serialNumber){
        return (serialNumber.length() <= MAX_SERIAL_NUMBER_LENGTH);
    }
}
