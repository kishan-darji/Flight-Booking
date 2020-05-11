package com.demo.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.flightbooking.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	Flight findByFlightNumber(String flightNumber);
}
