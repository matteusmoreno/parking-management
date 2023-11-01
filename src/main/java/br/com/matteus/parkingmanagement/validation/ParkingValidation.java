package br.com.matteus.parkingmanagement.validation;

import br.com.matteus.parkingmanagement.entity.Parking;
import br.com.matteus.parkingmanagement.entity.Vehicle;
import br.com.matteus.parkingmanagement.exception.NoParkingSpaceAvailableException;
import br.com.matteus.parkingmanagement.exception.VehicleAlreadyParkedException;
import org.springframework.stereotype.Component;

@Component
public class ParkingValidation {

    public void NoParkingSpaceAvailable(Parking parking) {
        if (parking.getCarSpaces() == 0 || parking.getMotorcycleSpaces() == 0) {
            throw new NoParkingSpaceAvailableException("No parking space available");
        }
    }


}
