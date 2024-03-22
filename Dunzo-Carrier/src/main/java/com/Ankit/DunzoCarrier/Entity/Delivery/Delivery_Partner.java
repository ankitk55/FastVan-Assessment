package com.Ankit.DunzoCarrier.Entity.Delivery;

import com.Ankit.DunzoCarrier.Entity.Enum.VehicleType;
import com.Ankit.DunzoCarrier.Entity.address.AddressLatLng;
import com.Ankit.DunzoCarrier.Entity.contactDetails.Mobile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Delivery_Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;
    private String name;
    private VehicleType vehicleType;
    private String vehicleNumber;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private AddressLatLng location;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Mobile mobile;
}
