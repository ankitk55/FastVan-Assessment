package com.Ankit.DunzoCarrier.service;

import com.Ankit.DunzoCarrier.Entity.Delivery.Vehicle;
import com.Ankit.DunzoCarrier.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
@Autowired
VehicleRepo vehicleRepo;
    public Vehicle savevehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepo.findAll();
    }
}
