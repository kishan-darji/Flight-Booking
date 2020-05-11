package com.demo.flightbooking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.demo.flightbooking.config.AuditLogEntityListener;
import com.demo.flightbooking.core.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="schedule")
@EntityListeners(AuditLogEntityListener.class)
public class Schedule extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="flight_id")
	private Flight flight;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "schedule_time")
	private Date scheduleTime;
	
	@Column(name = "schedule_seat")
	private Long scheduleSeat;	
	
	@Column(name = "available_seat")
	private Long availableSeat;	
}
