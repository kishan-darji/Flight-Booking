package com.demo.flightbooking.service.impl;

import java.util.Calendar;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.flightbooking.dto.BookingVO;
import com.demo.flightbooking.entity.Booking;
import com.demo.flightbooking.entity.Flight;
import com.demo.flightbooking.entity.Schedule;
import com.demo.flightbooking.enums.ResponseCode;
import com.demo.flightbooking.repository.BookingRepository;
import com.demo.flightbooking.repository.FlightRepository;
import com.demo.flightbooking.repository.ScheduleRepository;
import com.demo.flightbooking.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	@Transactional
	public BookingVO bookSeat(BookingVO vo) {
		BookingVO bookingVO = new BookingVO();
		Flight flight = flightRepository.findByFlightNumber(vo.getFlightNumber());
		if(Objects.isNull(flight)) {
			bookingVO.setMessage("Flight is not exists");
			return bookingVO; 
		}		
		Schedule scheduleByFlightNumber = scheduleRepository.findByFlightFlightNumber(vo.getFlightNumber());
		if(Objects.isNull(scheduleByFlightNumber)) {
			bookingVO.setMessage("Please create schedule first");
			return bookingVO; 
		}
		if(scheduleByFlightNumber.getAvailableSeat()-1>=0) {
			Booking booking = new Booking();
			booking.setFlight(flight);
			booking.setPassengerName(vo.getUserName());
			booking.setBookingTime(Calendar.getInstance().getTime());
			scheduleByFlightNumber.setAvailableSeat(scheduleByFlightNumber.getAvailableSeat()-1);
			scheduleRepository.save(scheduleByFlightNumber);
			booking.setSeatNumber((scheduleByFlightNumber.getScheduleSeat()-scheduleByFlightNumber.getAvailableSeat())+"");
			bookingRepository.save(booking);
			
			bookingVO.setStatus(ResponseCode.SUCCESSFUL.getName());
			bookingVO.setMessage(ResponseCode.SUCCESSFUL.getName());
			bookingVO.setSeatNumber(booking.getSeatNumber());
			LOGGER.info("bookSeat -- "+booking);
			return bookingVO;
		}
		
		bookingVO.setStatus(ResponseCode.FAIL.getName());
		bookingVO.setMessage("Tickets full");
		
		return bookingVO;
	}
}
