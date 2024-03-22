package com.Ankit.DunzoCarrier.Entity.Delivery;

import com.Ankit.DunzoCarrier.Entity.Fare.Capacity;
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
public class Vehicle {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @JsonIgnore
    private Long Id;
   private String type;
   @ManyToOne
   @Cascade(CascadeType.ALL)
   private Fare fare;
   @ManyToOne
   @Cascade(CascadeType.ALL)
   private Capacity capicity;
   private String total_distance;

}
