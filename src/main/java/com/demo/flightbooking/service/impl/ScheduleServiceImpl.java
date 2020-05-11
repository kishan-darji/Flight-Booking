package com.demo.flightbooking.service.impl;

import java.util.Calendar;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.flightbooking.dto.ScheduleVO;
import com.demo.flightbooking.entity.Flight;
import com.demo.flightbooking.entity.Schedule;
import com.demo.flightbooking.enums.ResponseCode;
import com.demo.flightbooking.repository.FlightRepository;
import com.demo.flightbooking.repository.ScheduleRepository;
import com.demo.flightbooking.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public ScheduleVO getAvailableCount(String flightNumber) {
		ScheduleVO vo = new ScheduleVO(); 
		Schedule schedule = scheduleRepository.findByFlightFlightNumber(flightNumber);
		if(Objects.nonNull(schedule)){
			vo.setCount(schedule.getAvailableSeat());
			vo.setStatus(ResponseCode.SUCCESSFUL.getName());
			vo.setMessage(ResponseCode.SUCCESSFUL.getName());
		}
		LOGGER.info("getAvailableCount -- "+vo);
		return vo;
	}

	@Override
	@Transactional
	public ScheduleVO scheduleFlight(ScheduleVO vo) {
		ScheduleVO scheduleVO = new ScheduleVO();
		Flight flight = flightRepository.findByFlightNumber(vo.getFlightNumber());
		if(Objects.isNull(flight)) {
			scheduleVO.setMessage("Flight is not exists");
			return scheduleVO; 
		}		
		if(Objects.nonNull(scheduleRepository.findByFlightFlightNumber(vo.getFlightNumber()))) {
			scheduleVO.setMessage("Flight already exists");
			return scheduleVO; 
		}
		Schedule schedule = new Schedule();
		schedule.setAvailableSeat(vo.getNoOfSeats());
		schedule.setScheduleSeat(vo.getNoOfSeats());
		schedule.setScheduleTime(Calendar.getInstance().getTime());
		schedule.setFlight(flight);
		scheduleRepository.save(schedule);
		scheduleVO.setStatus(ResponseCode.SUCCESSFUL.getName());
		scheduleVO.setMessage(ResponseCode.SUCCESSFUL.getName());
		LOGGER.info("scheduleFlight -- "+schedule);
		return scheduleVO;
	}
}
