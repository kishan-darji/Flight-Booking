package com.demo.flightbooking.service;

import java.util.List;

import com.demo.flightbooking.dto.ResponseVO;
import com.demo.flightbooking.dto.FlightVO;

public interface FlightService {

	List<FlightVO> findAll();

	ResponseVO<Long> save(FlightVO vo);
/*
	ResponseVO<Long> update(FlightVO vo);

	ResponseVO<Void> delete(Long id);*/

}
