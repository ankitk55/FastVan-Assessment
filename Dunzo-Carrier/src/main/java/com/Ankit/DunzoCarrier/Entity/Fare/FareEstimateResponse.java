package com.Ankit.DunzoCarrier.Entity.Fare;

import com.Ankit.DunzoCarrier.Entity.Delivery.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FareEstimateResponse {
    private List<Vehicle> vehicles;
}
