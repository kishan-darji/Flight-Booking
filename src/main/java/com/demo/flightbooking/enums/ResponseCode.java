package com.demo.flightbooking.enums;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;


@Getter
public enum ResponseCode{
	
	 SUCCESSFUL(200,"Success"),
	 FAIL(500,"Failure");	 
	 
	 static final Map<Integer, ResponseCode> MAP = new HashMap<>();
	 static{
		for (ResponseCode type : values()) {
	           MAP.put(type.id, type);
	       }
	}
		
    private final Integer id;
    private final String name;

    ResponseCode(Integer id, String name) {
        this.id = id;
        this.name = name;
    }	
	
	@SuppressWarnings("unlikely-arg-type")
	public static ResponseCode fromId(String string) {
     
        return MAP.get(string);
    }
}