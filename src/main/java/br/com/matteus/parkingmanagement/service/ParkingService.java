package br.com.matteus.parkingmanagement.service;

import br.com.matteus.parkingmanagement.repository.VehicleRepository;
import br.com.matteus.parkingmanagement.request.ParkingVehicleRequest;
import br.com.matteus.parkingmanagement.utils.ParkingUtils;
import br.com.matteus.parkingmanagement.entity.Parking;
import br.com.matteus.parkingmanagement.repository.ParkingRepository;
import br.com.matteus.parkingmanagement.request.CreateParkingRequest;
import br.com.matteus.parkingmanagement.request.UpdateParkingRequest;
import br.com.matteus.parkingmanagement.validation.ParkingValidation;
import br.com.matteus.parkingmanagement.validation.VehicleValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;
    private final VehicleRepository vehicleRepository;
    private final ParkingUtils parkingUtils;
    private final ParkingValidation parkingValidation;
    private final VehicleValidation vehicleValidation;
    @Autowired
    public ParkingService(ParkingRepository parkingRepository, VehicleRepository vehicleRepository, ParkingUtils parkingUtils, ParkingValidation parkingValidation, VehicleValidation vehicleValidation) {
        this.parkingRepository = parkingRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingUtils = parkingUtils;
        this.parkingValidation = parkingValidation;
        this.vehicleValidation = vehicleValidation;
    }

    public Parking create(CreateParkingRequest request) {
        var parking = new Parking();
        parkingUtils.setCreateAttributes(parking, request);
        return parking;

    }

    public Parking details(Long id) {
        return parkingRepository.getReferenceById(id);
    }

    public Parking update(UpdateParkingRequest request) {
        var parking = parkingRepository.getReferenceById(request.id());
        parkingUtils.setUpdateAttributes(parking, request);
        return parking;
    }

    public Parking disable(Long id) {
        var parking = parkingRepository.getReferenceById(id);
        parkingUtils.setDisableAttributes(parking);
        return parking;
    }

    public Parking enable(Long id) {
        var parking = parkingRepository.getReferenceById(id);
        parkingUtils.setEnableAttributes(parking);
        return parking;
    }

    public Parking parkVehicle(ParkingVehicleRequest request) {
        var parking = parkingRepository.getReferenceById(request.parkingId());
        var vehicle = vehicleRepository.getReferenceById(request.vehicleId());

        parkingValidation.NoParkingSpaceAvailable(parking);
        vehicleValidation.VehicleAlreadyParked(vehicle);

        if (Objects.equals(vehicle.getType().getDisplayName(), "Carro")) {
            vehicle.setIsParked(true);
            parking.setParkedCars(parking.getParkedCars() + 1);
            parking.setCarSpaces(parking.getCarSpaces() - 1);
        }

        if (Objects.equals(vehicle.getType().getDisplayName(), "Moto")) {
            vehicle.setIsParked(true);
            parking.setParkedMotorcycles(parking.getParkedMotorcycles() + 1);
            parking.setMotorcycleSpaces(parking.getMotorcycleSpaces() - 1);
        }

        return parking;
    }
}
