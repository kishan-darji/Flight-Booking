package com.demo.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.flightbooking.dto.ScheduleVO;
import com.demo.flightbooking.service.ScheduleService;

@CommonRestController
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/getAvailableSeats")
	public ResponseEntity<ScheduleVO> getAvailableCount(@RequestParam("flightNumber") String flightNumber){
		ScheduleVO scheduleVO = scheduleService.getAvailableCount(flightNumber);
		
		return new ResponseEntity<>(scheduleVO,HttpStatus.OK);
		
	}
	
	@PostMapping("/scheduleFlight")
	public ResponseEntity<ScheduleVO> scheduleFlight(@RequestBody ScheduleVO scheduleVO){
		return new ResponseEntity<ScheduleVO>(scheduleService.scheduleFlight(scheduleVO),HttpStatus.OK);
	}
	
}
