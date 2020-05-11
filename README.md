# Flight Booking

## Features

This application has 4 Rest API:

1. POST /api/v2/json/flight  (AddFlight)
2. POST /api/v2/json/scheduleFlight  (ScheduleFlight)
3. GET  /api/v2/json/getAvailableSeats?flightNumber=ABC (GetAvailableSeat)
4. POST /api/v2/json/bookSeat  (BookSeat)

Please Find Attach Postman collection for Rest API

## Technologies used

1. Java (Programming Language)
2. Spring Boot (Application Platform)
3. Spring Data JPA (Data persistence)
4. MySQL (Database)
5. Database Migrations with Flyway

## Getting Started

Follow these steps for the command-line option:  

### Prerequisites
1. Java 8
2. Maven 3
3. Git


### Installing & Running

#### Clone this repo into your local: 
	
```
git clone https://github.com/kishan-darji/Flight-Booking.git
```

####  Build using maven 
	
```
mvn clean install
```
	
#### Start the app
	
```
mvn spring-boot:run
```
