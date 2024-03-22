package com.Ankit.DunzoCarrier.Entity.Order;

import com.Ankit.DunzoCarrier.Entity.Delivery.Delivery_Partner;
import com.Ankit.DunzoCarrier.Entity.Enum.OrderStatus;
import com.Ankit.DunzoCarrier.Entity.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateOrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long requestId;
    private String orderId;
    @ManyToOne
    private Delivery_Partner partnerInfo;
    private OrderStatus orderStatus;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    Address pickupDetails;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    Address  dropDetails;
    String additionalComments;
    private LocalDateTime orderCreationTime;
    @Transient
    private Long partnerId;
}
