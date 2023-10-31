package br.com.matteus.parkingmanagement.repository;

import br.com.matteus.parkingmanagement.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
