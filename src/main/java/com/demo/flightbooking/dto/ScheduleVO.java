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
public class ScheduleVO extends ResponseVO<ScheduleVO> {

	private Long id;
	
	private String flightNumber;
	
	private Long noOfSeats;
	
	@Temporal(TemporalType.DATE)
	private Date scheduleTime;
	
	private Long scheduleSeat;	
	
	private Long availableSeat;
	
	private Long count;
}
