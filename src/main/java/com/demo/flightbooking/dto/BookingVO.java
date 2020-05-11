package com.demo.flightbooking.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingVO extends ResponseVO<BookingVO> {

	private Long id;

	private String flightNumber;
	
	@Temporal(TemporalType.DATE)
	private Date bookingTime;
	
	private String userName;	
	
	private String seatNumber;
}
