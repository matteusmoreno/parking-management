package br.com.matteus.parkingmanagement.service;

import br.com.matteus.parkingmanagement.entity.Vehicle;
import br.com.matteus.parkingmanagement.repository.VehicleRepository;
import br.com.matteus.parkingmanagement.request.CreateVehicleRequest;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle create(CreateVehicleRequest request) {
        var vehicle = new Vehicle();

        vehicle.setBrand(request.brand());
        vehicle.setModel(request.model());
        vehicle.setColor(request.color());
        vehicle.setPlate(request.plate());
        vehicle.setType(request.type());

        vehicleRepository.save(vehicle);

        return vehicle;
    }
}
