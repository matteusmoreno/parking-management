package br.com.matteus.parkingmanagement.validation;

import br.com.matteus.parkingmanagement.entity.Vehicle;
import br.com.matteus.parkingmanagement.exception.VehicleAlreadyParkedException;
import org.springframework.stereotype.Component;

@Component
public class VehicleValidation {

    public void VehicleAlreadyParked(Vehicle vehicle) {
        if (vehicle.getIsParked()) {
            throw new VehicleAlreadyParkedException("Vehicle already parked");
        }
    }
}
