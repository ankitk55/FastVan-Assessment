package com.Ankit.DunzoCarrier.Entity.Fare;

import com.Ankit.DunzoCarrier.Entity.customer.CustomerDetails;
import com.Ankit.DunzoCarrier.Entity.address.AddressLatLng;
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
public class FareEstimateRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long requestId;
  @ManyToOne
  @Cascade(CascadeType.ALL)
  private AddressLatLng pickup_details  ;
  @ManyToOne
  @Cascade(CascadeType.ALL)
    private  AddressLatLng  drop_details;
  @ManyToOne
  @Cascade(CascadeType.ALL)
   private CustomerDetails customer;
}
