package com.Ankit.DunzoCarrier.Entity.Order;

import com.Ankit.DunzoCarrier.Entity.Fare.Fare;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CreateOrderResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String orderId;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Fare estimatedFareDetails;
    private String trackingUrl;
}
