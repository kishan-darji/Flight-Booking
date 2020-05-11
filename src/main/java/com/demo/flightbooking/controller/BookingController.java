package com.demo.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.flightbooking.dto.BookingVO;
import com.demo.flightbooking.service.BookingService;

@CommonRestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/bookSeat")
	public ResponseEntity<BookingVO> bookSeat(@RequestBody BookingVO bookingVO){
		return new ResponseEntity<BookingVO>(bookingService.bookSeat(bookingVO),HttpStatus.OK);
	}
}
