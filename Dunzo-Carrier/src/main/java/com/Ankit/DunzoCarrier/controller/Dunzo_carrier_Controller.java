package com.Ankit.DunzoCarrier.controller;

import com.Ankit.DunzoCarrier.Entity.Delivery.Delivery_Partner;
import com.Ankit.DunzoCarrier.Entity.Delivery.Vehicle;
import com.Ankit.DunzoCarrier.Entity.Enum.OrderStatus;
import com.Ankit.DunzoCarrier.Entity.Fare.Capacity;
import com.Ankit.DunzoCarrier.Entity.Fare.Fare;
import com.Ankit.DunzoCarrier.Entity.Fare.FareEstimateRequest;
import com.Ankit.DunzoCarrier.Entity.Fare.FareEstimateResponse;
import com.Ankit.DunzoCarrier.Entity.Order.CreateOrderRequest;
import com.Ankit.DunzoCarrier.Entity.Order.CreateOrderResponse;
import com.Ankit.DunzoCarrier.Entity.Order.TrackOrderResponse;
import com.Ankit.DunzoCarrier.service.AddressLatLanService;
import com.Ankit.DunzoCarrier.service.CreateOrderRequestService;
import com.Ankit.DunzoCarrier.service.Delivery_PartnerService;
import com.Ankit.DunzoCarrier.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.Ankit.DunzoCarrier.DistanceCalculator.calculateDistance;

@RestController
@RequestMapping("/v1")
public class Dunzo_carrier_Controller {
@Autowired
    VehicleService vehicleService;
@Autowired
AddressLatLanService addressLatLanService;
@Autowired
    CreateOrderRequestService createOrderRequestService;
@Autowired
    Delivery_PartnerService deliveryPartnerService;
    @GetMapping("/getQuots")
    public ResponseEntity<FareEstimateResponse>getQuots(@RequestBody FareEstimateRequest request){
        double lat1 =request.getPickup_details().getLat();
        double lon1 =request.getPickup_details().getLng();
        double lat2 =request.getDrop_details().getLat();
        double lon2 =request.getDrop_details().getLng();

        double distance = calculateDistance(lat1, lon1, lat2, lon2);

        FareEstimateResponse fe =new FareEstimateResponse();
        List<Vehicle>AllVehicle = vehicleService.getAllVehicle();
        System.out.println("All-->>"+AllVehicle);

        List<Vehicle>UpdateVehicle =  new ArrayList<>();
        for(Vehicle vv :AllVehicle) {
            Vehicle nv =new Vehicle();
            if(vv.getType().equals("2-Wheeler")){
                Fare fair =new Fare();
                Capacity c = new Capacity();
                nv.setType(vv.getType());
                c.setUnit("kg");
                c.setValue("20");
                fair.setCurrency("INR");
                fair.setAmount((distance*10)+"");
                nv.setFare(fair);
                nv.setCapicity(c);
            }else if(vv.getType().equals("3-Wheeler")){
                nv.setType(vv.getType());
                Fare fair =new Fare();
                Capacity c = new Capacity();
                c.setUnit("kg");
                c.setValue("100");
                fair.setCurrency("INR");
                fair.setAmount((distance*15)+"");
                nv.setFare(fair);
                nv.setCapicity(c);
            }else{
                nv.setType(vv.getType());
                Fare fair =new Fare();
                Capacity c = new Capacity();
                c.setUnit("ton");
                c.setValue("5");
                fair.setCurrency("INR");
                fair.setAmount((distance*20)+"");
                nv.setFare(fair);
                nv.setCapicity(c);
            }
            nv.setTotal_distance(distance+" km");


            UpdateVehicle.add(nv);
        }



        fe.setVehicles(UpdateVehicle);
        return ResponseEntity.ok(fe);
    }


    @PostMapping("/orders/create")
    public ResponseEntity<CreateOrderResponse>createOrder(@RequestBody CreateOrderRequest request){
        CreateOrderResponse cr =new CreateOrderResponse();
        request.setOrderId(UUID.randomUUID().toString());
        request.setOrderStatus(OrderStatus.ACCEPTED);

        request.setOrderCreationTime(LocalDateTime.now());
        Long partnerId =request.getPartnerId();
        if(partnerId==null){
            return new ResponseEntity<>(cr,HttpStatus.BAD_REQUEST);
        }
        Optional<Delivery_Partner>ddp =deliveryPartnerService.findById(partnerId);
        if(!ddp.isPresent()){

            return new ResponseEntity<>(cr,HttpStatus.NOT_FOUND);
        }
        request.setPartnerInfo(ddp.get());
        Double lat1 =request.getPickupDetails().getLat();
        Double lng1 =request.getPickupDetails().getLng();
        Double lat2 =request.getDropDetails().getLat();
        Double lng2 =request.getDropDetails().getLng();

        double distance = calculateDistance(lat1, lng1, lat2, lng2);

       Delivery_Partner dp= ddp.get();
       System.out.println(dp.getVehicleType());
       String vehType =dp.getVehicleType().toString();
       if(vehType.trim().equalsIgnoreCase("TWO_WHEELER")){
           Fare f = new Fare();
           f.setCurrency("INR");
           f.setAmount(distance*10+"");
           f.setDistance(distance+"");
           cr.setEstimatedFareDetails(f);
       }else if(vehType.trim().equalsIgnoreCase("THREE_WHEELER")){
           Fare f = new Fare();
           f.setCurrency("INR");
           f.setAmount(distance*20+"");
           f.setDistance(distance+"");
           cr.setEstimatedFareDetails(f);
       }else{
           Fare f = new Fare();
           f.setCurrency("INR");
           f.setAmount(distance*30+"");
           f.setDistance(distance+"");
           cr.setEstimatedFareDetails(f);
       }


        cr.setOrderId(request.getOrderId());
       cr.setTrackingUrl("localhost:8080/order/track?orderId="+request.getOrderId());
        createOrderRequestService.saveOrder(request);
        return new ResponseEntity<>(cr, HttpStatus.CREATED);


    }

    @GetMapping("/order/track")
    public ResponseEntity<TrackOrderResponse>getOrder(@RequestParam String orderId){
        TrackOrderResponse tr = new TrackOrderResponse();
        Optional<CreateOrderRequest>order= createOrderRequestService.getorderById(orderId);
        if(!order.isPresent()){
           return new ResponseEntity<>(tr,HttpStatus.NOT_FOUND);
        }
        CreateOrderRequest ord =order.get();
        System.out.println(ord);

        tr.setOrderId(ord.getOrderId());
        tr.setOrderStatus(ord.getOrderStatus());

        Double lat1 =ord.getPickupDetails().getLat();
        Double lng1 =ord.getPickupDetails().getLng();
        Double lat2 =ord.getDropDetails().getLat();
        Double lng2 =ord.getDropDetails().getLng();

        double distance = calculateDistance(lat1, lng1, lat2, lng2);



        String vehType =ord.getPartnerInfo().getVehicleType().toString();
        if(vehType.trim().equalsIgnoreCase("TWO_WHEELER")){
            Fare f = new Fare();
            f.setCurrency("INR");
            f.setDistance(distance+"");
            f.setAmount(distance*10+"");
           tr.setEstdFare(f);
        }else if(vehType.trim().equalsIgnoreCase("THREE_WHEELER")){
            Fare f = new Fare();
            f.setCurrency("INR");
            f.setDistance(distance+"");
            f.setAmount(distance*20+"");
            tr.setEstdFare(f);
        }else{
            Fare f = new Fare();
            f.setCurrency("INR");
            f.setAmount(distance*30+"");
            f.setDistance(distance+"");
            tr.setEstdFare(f);
        }
       tr.setPartnerIfo(ord.getPartnerInfo());
        return new ResponseEntity<>(tr,HttpStatus.OK);
    }
    @PostMapping("add/partner")
    public Delivery_Partner addPartner(@RequestBody Delivery_Partner deliveryPartner){
        return deliveryPartnerService.save(deliveryPartner);
    }
    @GetMapping("partners")
    public List<Delivery_Partner>allPartners(){
        return deliveryPartnerService.getAll();
    }
//    @PostMapping("svaevehicle")
//    public Vehicle svaee (@RequestBody Vehicle vehicle){
//        return vehicleService.savevehicle(vehicle);
//    }

//    @PostMapping("svaeAddress")
//    public AddressLatLng svaeee (@RequestBody AddressLatLng addressLatLng){
//        return addressLatLanService.saveAdd(addressLatLng);
//    }

}
