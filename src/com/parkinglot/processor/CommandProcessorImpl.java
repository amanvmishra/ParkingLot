package com.parkinglot.processor;

import com.parkinglot.utils.ParkingUtil;

public abstract class CommandProcessorImpl implements CommandProcessor {

	ParkingUtil parkingUtil = null;
	
	public CommandProcessorImpl(ParkingUtil parkingUtil) {
		this.parkingUtil = parkingUtil;
	}
	
	
}
