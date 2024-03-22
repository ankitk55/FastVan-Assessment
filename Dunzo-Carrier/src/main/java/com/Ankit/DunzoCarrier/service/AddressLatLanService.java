package com.Ankit.DunzoCarrier.service;

import com.Ankit.DunzoCarrier.Entity.address.AddressLatLng;
import com.Ankit.DunzoCarrier.repository.AddressLatLanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressLatLanService {
    @Autowired
    AddressLatLanRepo addressLatLanRepo;
    public AddressLatLng saveAdd(AddressLatLng addressLatLng) {
        return addressLatLanRepo.save(addressLatLng);
    }
}
