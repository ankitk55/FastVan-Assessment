package com.Ankit.DunzoCarrier.Entity.Order;

import com.Ankit.DunzoCarrier.Entity.Delivery.Delivery_Partner;
import com.Ankit.DunzoCarrier.Entity.Enum.OrderStatus;
import com.Ankit.DunzoCarrier.Entity.Fare.Fare;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrackOrderResponse {
    private String orderId;
    private OrderStatus orderStatus;
    private Delivery_Partner partnerIfo;
    private Fare estdFare;
}
