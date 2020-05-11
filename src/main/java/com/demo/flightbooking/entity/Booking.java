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
@Table(name="booking")
@EntityListeners(AuditLogEntityListener.class)
public class Booking extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="flight_id")
	private Flight flight;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "booking_time")
	private Date bookingTime;
	
	@Column(name = "passenger_name")
	private String passengerName;	
	
	@Column(name = "seat_number")
	private String seatNumber;	
}
