package br.com.matteus.parkingmanagement.controller;

import br.com.matteus.parkingmanagement.request.CreateParkingRequest;
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
}
