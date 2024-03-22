package com.Ankit.DunzoCarrier.service;

import com.Ankit.DunzoCarrier.Entity.Delivery.Delivery_Partner;
import com.Ankit.DunzoCarrier.repository.Delivery_PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Delivery_PartnerService {
    @Autowired
    Delivery_PartnerRepo deliveryPartnerRepo;

    public  Optional<Delivery_Partner> findById(Long partnerId) {
        return deliveryPartnerRepo.findById(partnerId);
    }

    public Delivery_Partner save(Delivery_Partner deliveryPartner) {
        return deliveryPartnerRepo.save(deliveryPartner);
    }

    public List<Delivery_Partner> getAll() {
        return deliveryPartnerRepo.findAll();
    }
}
