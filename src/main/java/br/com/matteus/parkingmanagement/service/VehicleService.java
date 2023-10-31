package br.com.matteus.parkingmanagement.service;

import br.com.matteus.parkingmanagement.entity.Vehicle;
import br.com.matteus.parkingmanagement.repository.VehicleRepository;
import br.com.matteus.parkingmanagement.request.CreateVehicleRequest;
import br.com.matteus.parkingmanagement.request.UpdateVehicleRequest;
import br.com.matteus.parkingmanagement.validation.VehicleValidation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleValidation vehicleValidation;
    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, VehicleValidation vehicleValidation) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleValidation = vehicleValidation;
    }

    public Vehicle create(CreateVehicleRequest request) {
        var vehicle = new Vehicle();

        vehicle.setBrand(request.brand());
        vehicle.setModel(request.model());
        vehicle.setColor(request.color());
        vehicle.setPlate(request.plate());
        vehicle.setType(request.type());

        vehicle.setCreatedAt(LocalDateTime.now());
        vehicle.setActive(true);

        vehicleRepository.save(vehicle);

        return vehicle;
    }

    public Vehicle details(Long id) {
        return vehicleRepository.getReferenceById(id);
    }

    public Vehicle update(UpdateVehicleRequest request) {
        var vehicle = vehicleRepository.getReferenceById(request.id());

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

        return vehicle;
    }

    public Vehicle disable(Long id) {
        var vehicle = vehicleRepository.getReferenceById(id);
        vehicle.setActive(false);

        vehicle.setDeletedAt(LocalDateTime.now());

        return vehicle;
    }
}
