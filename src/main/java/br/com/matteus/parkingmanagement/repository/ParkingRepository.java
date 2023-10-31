package br.com.matteus.parkingmanagement.repository;

import br.com.matteus.parkingmanagement.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
