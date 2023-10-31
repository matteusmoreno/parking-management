package br.com.matteus.parkingmanagement.controller;

import br.com.matteus.parkingmanagement.request.CreateVehicleRequest;
import br.com.matteus.parkingmanagement.response.VehicleDetailsResponse;
import br.com.matteus.parkingmanagement.service.VehicleService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateVehicleRequest request, UriComponentsBuilder uriBuilder) {
        var vehicle = vehicleService.create(request);
        var uri = uriBuilder.path("/vehicles/{id}").buildAndExpand(vehicle.getId()).toUri();
        return ResponseEntity.created(uri).body(new VehicleDetailsResponse(vehicle));
    }

}
