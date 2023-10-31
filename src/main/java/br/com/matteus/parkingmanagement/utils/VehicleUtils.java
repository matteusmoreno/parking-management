package br.com.matteus.parkingmanagement.utils;

import br.com.matteus.parkingmanagement.entity.Vehicle;
import br.com.matteus.parkingmanagement.repository.VehicleRepository;
import br.com.matteus.parkingmanagement.request.CreateVehicleRequest;
import br.com.matteus.parkingmanagement.request.UpdateVehicleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VehicleUtils {

    private final VehicleRepository vehicleRepository;
    @Autowired
    public VehicleUtils(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    public void setCreateAttributes(Vehicle vehicle, CreateVehicleRequest request) {
        vehicle.setBrand(request.brand());
        vehicle.setModel(request.model());
        vehicle.setColor(request.color());
        vehicle.setPlate(request.plate());
        vehicle.setType(request.type());

        vehicle.setCreatedAt(LocalDateTime.now());
        vehicle.setActive(true);

        vehicleRepository.save(vehicle);
    }

    public void setUpdateAttributes(Vehicle vehicle, UpdateVehicleRequest request) {
        if (request.brand() != null) {
            vehicle.setBrand(request.brand());
        }
        if (request.model() != null) {
            vehicle.setModel(request.model());
        }
        if (request.color() != null) {
            vehicle.setColor(request.color());
        }
        if (request.plate() != null) {
            vehicle.setPlate(request.plate());
        }
        if (request.type() != null) {
            vehicle.setType(request.type());
        }

        vehicle.setUpdatedAt(LocalDateTime.now());
        vehicleRepository.save(vehicle);
    }

    public void setDisableAttributes(Vehicle vehicle) {
        vehicle.setActive(false);
        vehicle.setDeletedAt(LocalDateTime.now());
        vehicleRepository.save(vehicle);
    }

    public void setEnableAttributes(Vehicle vehicle) {
        vehicle.setActive(true);
        vehicle.setDeletedAt(null);
        vehicle.setUpdatedAt(LocalDateTime.now());
        vehicleRepository.save(vehicle);
    }
}
