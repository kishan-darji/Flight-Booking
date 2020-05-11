package com.demo.flightbooking.service;

import com.demo.flightbooking.dto.ScheduleVO;

public interface ScheduleService {

	ScheduleVO getAvailableCount(String flightNumber);
	
	ScheduleVO scheduleFlight(ScheduleVO vo);
	
/*	ResponseVO<List<UserVO>> findAll();

	ResponseVO<UserVO> findById(Long id);

	ResponseVO<Long> save(UserVO vo);

	ResponseVO<Long> update(UserVO vo);

	ResponseVO<Void> delete(Long id);*/

}
