package com.demo.flightbooking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlightVO extends ResponseVO<FlightVO> {

	private Long id;	
	private String flightNumber;
}
