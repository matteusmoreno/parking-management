package br.com.matteus.parkingmanagement.service;

import br.com.matteus.parkingmanagement.utils.ParkingUtils;
import br.com.matteus.parkingmanagement.entity.Parking;
import br.com.matteus.parkingmanagement.repository.ParkingRepository;
import br.com.matteus.parkingmanagement.request.CreateParkingRequest;
import br.com.matteus.parkingmanagement.request.UpdateParkingRequest;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;
    private final ParkingUtils parkingUtils;

    public ParkingService(ParkingRepository parkingRepository, ParkingUtils parkingUtils) {
        this.parkingRepository = parkingRepository;
        this.parkingUtils = parkingUtils;
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
}
