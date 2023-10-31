package br.com.matteus.parkingmanagement.service;

import br.com.matteus.parkingmanagement.entity.Vehicle;
import br.com.matteus.parkingmanagement.repository.VehicleRepository;
import br.com.matteus.parkingmanagement.request.CreateVehicleRequest;
import br.com.matteus.parkingmanagement.request.UpdateVehicleRequest;
import br.com.matteus.parkingmanagement.utils.VehicleUtils;
import br.com.matteus.parkingmanagement.validation.VehicleValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleValidation vehicleValidation;
    private final VehicleUtils vehicleUtils;
    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, VehicleValidation vehicleValidation, VehicleUtils vehicleUtils) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleValidation = vehicleValidation;
        this.vehicleUtils = vehicleUtils;
    }

    public Vehicle create(CreateVehicleRequest request) {
        var vehicle = new Vehicle();
        vehicleUtils.setCreateAttributes(vehicle, request);
        return vehicle;
    }

    public Vehicle details(Long id) {
        return vehicleRepository.getReferenceById(id);
    }

    public Vehicle update(UpdateVehicleRequest request) {
        var vehicle = vehicleRepository.getReferenceById(request.id());
        vehicleUtils.setUpdateAttributes(vehicle, request);
        return vehicle;
    }

    public Vehicle disable(Long id) {
        var vehicle = vehicleRepository.getReferenceById(id);
        vehicleUtils.setDisableAttributes(vehicle);
        return vehicle;
    }

    public Vehicle enable(Long id) {
        var vehicle = vehicleRepository.getReferenceById(id);
        vehicleUtils.setEnableAttributes(vehicle);
        return vehicle;
    }
}
