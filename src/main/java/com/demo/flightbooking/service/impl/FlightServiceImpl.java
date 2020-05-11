package com.demo.flightbooking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.flightbooking.dto.FlightVO;
import com.demo.flightbooking.dto.ResponseVO;
import com.demo.flightbooking.entity.Flight;
import com.demo.flightbooking.enums.ResponseCode;
import com.demo.flightbooking.repository.FlightRepository;
import com.demo.flightbooking.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceImpl.class);

	@Autowired
	private FlightRepository flightRepository;

	@Override
	public List<FlightVO> findAll() {
		List<Flight> flights = flightRepository.findAll();
		List<FlightVO> flightVOs = new ArrayList<>(flights.size());

		flights.stream().forEach(x -> {
			FlightVO dto = new FlightVO();
			BeanUtils.copyProperties(x, dto);
			dto.setStatus(ResponseCode.SUCCESSFUL.getName());
			dto.setMessage(ResponseCode.SUCCESSFUL.getName());
			flightVOs.add(dto);
		});
		LOGGER.info("Get Flights Data "+flightVOs);
		return flightVOs;
	}
	
	@Override
	@Transactional
	public ResponseVO<Long> save(FlightVO vo) {		

		Flight flight = new Flight();
		BeanUtils.copyProperties(vo, flight);
		Flight saveFlight = flightRepository.save(flight);
		
		LOGGER.info("Save Flights Data "+saveFlight);
		
		return ResponseVO.create(ResponseCode.SUCCESSFUL.getName(), "Flight Added Successfully");
	}
}
