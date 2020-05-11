package com.demo.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.flightbooking.dto.FlightVO;
import com.demo.flightbooking.dto.ResponseVO;
import com.demo.flightbooking.service.FlightService;

@CommonRestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@GetMapping("/flight")
	public ResponseEntity<List<FlightVO>> findAll() {
		return new ResponseEntity<List<FlightVO>>(flightService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/flight")
	public ResponseVO<Long> save(@RequestBody FlightVO vo) {
		return flightService.save(vo); 
	}
	
	/*@PutMapping("/user")
	public ResponseVO<Long> update(@RequestBody UserVO vo) {
		return userService.update(vo); 
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseVO<Void> delete(@PathVariable("id") Long id) {
		return userService.delete(id); 
	}*/
}
