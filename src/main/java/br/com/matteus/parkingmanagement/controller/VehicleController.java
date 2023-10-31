package br.com.matteus.parkingmanagement.controller;

import br.com.matteus.parkingmanagement.request.CreateVehicleRequest;
import br.com.matteus.parkingmanagement.request.UpdateVehicleRequest;
import br.com.matteus.parkingmanagement.response.VehicleDetailsResponse;
import br.com.matteus.parkingmanagement.service.VehicleService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    @Autowired
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

    @GetMapping("/details/{id}")
    public ResponseEntity details(@PathVariable Long id) {
        var vehicle = vehicleService.details(id);
        return ResponseEntity.ok(new VehicleDetailsResponse(vehicle));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateVehicleRequest request) {
        var vehicle = vehicleService.update(request);
        return ResponseEntity.ok(new VehicleDetailsResponse(vehicle));
    }

    @PutMapping("/disable/{id}")
    @Transactional
    public ResponseEntity disable(@PathVariable Long id) {
        var vehicle = vehicleService.disable(id);
        return ResponseEntity.ok(new VehicleDetailsResponse(vehicle));
    }
}
