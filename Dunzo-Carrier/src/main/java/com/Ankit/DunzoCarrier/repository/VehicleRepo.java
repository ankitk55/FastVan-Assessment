package com.Ankit.DunzoCarrier.repository;

import com.Ankit.DunzoCarrier.Entity.Delivery.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,Long> {
}
