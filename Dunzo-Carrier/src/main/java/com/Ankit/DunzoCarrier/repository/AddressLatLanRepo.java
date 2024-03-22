package com.Ankit.DunzoCarrier.repository;

import com.Ankit.DunzoCarrier.Entity.address.AddressLatLng;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressLatLanRepo extends JpaRepository<AddressLatLng,Long> {
}
