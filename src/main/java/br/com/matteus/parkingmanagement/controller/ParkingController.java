package br.com.matteus.parkingmanagement.controller;

import br.com.matteus.parkingmanagement.request.CreateParkingRequest;
import br.com.matteus.parkingmanagement.request.ParkingVehicleRequest;
import br.com.matteus.parkingmanagement.request.UpdateParkingRequest;
import br.com.matteus.parkingmanagement.response.ParkingDetailsResponse;
import br.com.matteus.parkingmanagement.service.ParkingService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateParkingRequest request, UriComponentsBuilder uriBuilder) {
        var parking = parkingService.create(request);
        var uri = uriBuilder.path("/parking/{id}").buildAndExpand(parking.getId()).toUri();

        return ResponseEntity.created(uri).body(new ParkingDetailsResponse(parking));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity details(@PathVariable Long id) {
        var parking = parkingService.details(id);

        return ResponseEntity.ok(new ParkingDetailsResponse(parking));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateParkingRequest request) {
        var parking = parkingService.update(request);

        return ResponseEntity.ok(new ParkingDetailsResponse(parking));
    }

    @PutMapping("/disable/{id}")
    @Transactional
    public ResponseEntity disable(@PathVariable Long id) {
        var parking = parkingService.disable(id);

        return ResponseEntity.ok().body(new ParkingDetailsResponse(parking));
    }

    @PutMapping("/enable/{id}")
    @Transactional
    public ResponseEntity enable(@PathVariable Long id) {
        var parking = parkingService.enable(id);

        return ResponseEntity.ok().body(new ParkingDetailsResponse(parking));
    }

    @PutMapping("/park-vehicle")
    @Transactional
    public ResponseEntity parkVehicle(@RequestBody @Valid ParkingVehicleRequest request) {
        var parking = parkingService.parkVehicle(request);

        return ResponseEntity.ok().body(new ParkingDetailsResponse(parking));
    }
}
