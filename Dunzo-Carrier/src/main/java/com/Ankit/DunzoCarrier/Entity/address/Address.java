package com.Ankit.DunzoCarrier.Entity.address;

import com.Ankit.DunzoCarrier.Entity.contactDetails.ContactDetails;
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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private  Long id;
    private  String apartmentAddress;
    private  String streetAddress1;
    private  String streetAddress2;
    private String landmark;
    private  String city;
    private  String state;
    private  String pincode;
    private  String country;
    private Double lat;
    private Double lng;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private ContactDetails contactDetails;

}
