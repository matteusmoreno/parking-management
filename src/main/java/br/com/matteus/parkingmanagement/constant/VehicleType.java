package br.com.matteus.parkingmanagement.constant;

import lombok.Getter;

@Getter
public enum VehicleType {

    CAR("Carro"),
    MOTORCYCLE("Moto");

    private final String displayName;

    VehicleType(String displayName) {
        this.displayName = displayName;
    }
}
