# Dunzo-Carrier APIs


## Description

The Dunzo backend project is aimed at providing the core functionalities required for a delivery service platform similar to Dunzo. This backend system facilitates the creation, tracking, and management of orders, as well as retrieving quotes for delivery services.

##  Prerequisites
Before you begin, ensure you have met the following requirements:

**Java Development Kit (JDK):** Install JDK 17. You can download it from Oracle's website !.

**Database:**  Make sure you have the MYSQL database server installed and configured.

**Development Environment:** Set up your preferred development environment, such as IntelliJ IDEA, Eclipse, or Visual Studio Code, with appropriate plugins for Java and Spring Boot development.

**Version Control:** Use a version control system like Git to manage  project's source code.

## Endpoints:
### Create Order :
``` 
URI:    localhost:8080/v1/orders/create   
Method: POST
Status Code : 201
Data-Type: JSON

Request Body :
    {
    
    "pickupDetails":
  {
      "apartment_address": "27",
            "street_address1": "Sona Towers",
            "street_address2": "Krishna Nagar Industrial Area",
            "landmark": "Hosur Road",
            "city": "Bengaluru",
            "state": "Karnataka",
            "pincode": "560029",
            "country": "India",
            "lat": 12.935025018880504,
            "lng": 77.6092605236106,
            "contactDetails": {
                "name": "Test Sender",
                "countryCode":"+91",
                "phone": "+919876543210"
            }
        },
        "dropDetails":
        {
            "apartment_address": "this is apartment address",
            "street_address1": "BTM Layout",
            "street_address2": "This is My Order ID",
            "landmark": "BTM Layout",
            "city": "Bengaluru",
            "state": "Karnataka",
            "pincode": "560029",
            "country": "India",
            "lat": 12.947146336879577,
            "lng": 77.62102993895199,
             "contactDetails": {
                "name": "Test Sender",
                "countryCode":"+91",
                "phone": "+919876543210"
            }
        },
        "additionalComments":"This is additional comment",
        "partnerId":1
  }


  Response Body :
      {
    "orderId": "221b9cf1-634a-4d0a-aaf7-69bb41393a56",
    "estimatedFareDetails": {
        "currency": "INR",
        "amount": "55.669524465433994",
        "distance": "1.8556508155144664"
    },
    "trackingUrl": "localhost:8080/order/track?orderId=221b9cf1-634a-4d0a-aaf7-69bb41393a56"
}
  

```
### Track Order :
```
URI:   localhost:8080/v1/order/track?orderId=9a6a2f8d-0f8c-43d7-bbcc-df11ceae21a8  
Method: GET
Status Code : 200
Data-Type: JSON

Response Body :
{
    "orderId": "9a6a2f8d-0f8c-43d7-bbcc-df11ceae21a8",
    "orderStatus": "ACCEPTED",
    "partnerIfo": {
        "name": null,
        "vehicleType": "TWO_WHEELER",
        "vehicleNumber": "AP-12-23444",
        "location": {
            "lat": 12.54444,
            "lng": 34.35454
        },
        "mobile": {
            "countryCode": "+91",
            "phone_number": "68584848484"
        },
        "pid": 1
    },
    "estdFare": {
        "currency": "INR",
        "amount": "18.556508155144662",
        "distance": "1.8556508155144664"
    }
}
```

### Get Quote :
```
URI:   localhost:8080/v1/getQuots
Method:GET
Status Code: 200
Data-Type: JSON

Request Body:
{
    "pickup_details":
   {
       "lat":"28.2490",
       "lng":"77.8549"
   },
   "drop_details":
   {
      "lat":"27.8974",
       "lng":"78.0880"  
   },
   "CustomerDetails":{
       "name":"Ankit",
       "mobile":"8675747327"
   }
}

Response Body:
{
    "vehicles": [
        {
            "type": "2-Wheeler",
            "fare": {
                "currency": "INR",
                "amount": "452.9396049179154",
                "distance": null
            },
            "capicity": {
                "value": "20",
                "unit": "kg"
            },
            "total_distance": "45.29396049179154 km"
        },
        {
            "type": "3-Wheeler",
            "fare": {
                "currency": "INR",
                "amount": "679.4094073768731",
                "distance": null
            },
            "capicity": {
                "value": "100",
                "unit": "kg"
            },
            "total_distance": "45.29396049179154 km"
        },
        {
            "type": "4-Wheeler",
            "fare": {
                "currency": "INR",
                "amount": "905.8792098358308",
                "distance": null
            },
            "capicity": {
                "value": "5",
                "unit": "ton"
            },
            "total_distance": "45.29396049179154 km"
        }
    ]
}
```
### Add Delivery_Partner :
```
URI:   localhost:8080/v1/add/partner 
Method:POST
Status Code: 200
Data-Type:JSON

Request Body:
{   
    "name":"Test1",
    "vehicleType":"TWO_WHEELER",
    "vehicleNumber":"HP-12-23444",
    "location":
    {
        "lat":"12.54444",
        "lng":"34.35454"
    },
    "mobile":
    {
        "countryCode":"+91",
        "phone_number":"68584848484"
    }
}

Response Body:
{
    "name": "Test1",
    "vehicleType": "TWO_WHEELER",
    "vehicleNumber": "HP-12-23444",
    "location": {
        "lat": 12.54444,
        "lng": 34.35454
    },
    "mobile": {
        "countryCode": "+91",
        "phone_number": "68584848484"
    },
    "pid": 2
}
```

### Get All Delivery_Partners :
```
URI:   localhost:8080/v1/partners 
Method:Get
Status Code: 200
Data-Type:JSON

Response Body :
[
    {
        "name": "Test1",
        "vehicleType": "OTHER",
        "vehicleNumber": "HP-12-23444",
        "location": {
            "lat": 12.54444,
            "lng": 34.35454
        },
        "mobile": {
            "countryCode": "+91",
            "phone_number": "68584848484"
        },
        "pid": 1
    },
    {
        "name": "Test1",
        "vehicleType": "TWO_WHEELER",
        "vehicleNumber": "HP-12-23444",
        "location": {
            "lat": 12.54444,
            "lng": 34.35454
        },
        "mobile": {
            "countryCode": "+91",
            "phone_number": "68584848484"
        },
        "pid": 2
    }
]
```

### APIs Documentation
[view documentation](https://documenter.getpostman.com/view/27811473/2sA35Ba3f5)
### Technologies Used
```
- Programming Language: Java
- Web Framework: SpringBoot
- Database : The project utilizes the MySQL database for data storage.
- Hibernate (for ORM)
- Maven (for dependency management)

```
## EndPoints Http Response Code
| Http Response Code | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `201` | `Resource Created` | `Success ` |
| `404` | `not found`    | `whatever you trying to find that not found`  |
| `400` | `Bad Request` | `Input misMatch`  |
| `200`   |`OK`   | `All OK` |

### Author
 👨‍💼 **Ankit Kumar**
 + Github : [Ankit kumar](https://github.com/ankitk55?tab=repositories)
 + Linkdin : [Ankit Kumar](https://www.linkedin.com/in/ankit-kumar-7300581b3/)
 
### 🤝 Contributing
Contributions, issues and feature requests are Welcome!\
Feel free to check [issues Page](https://github.com/issues) 

### Show Your Support 
 Give a ⭐ if this project help you!
