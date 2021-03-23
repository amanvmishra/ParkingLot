package com.parkinglot.processor;

import java.util.List;

import com.parkinglot.model.CommandDTO;
import com.parkinglot.model.Driver;
import com.parkinglot.model.Vehicle;
import com.parkinglot.utils.ParkingUtil;

public class ParkVehicleCommandProcessorImpl extends CommandProcessorImpl {

	public ParkVehicleCommandProcessorImpl(ParkingUtil parkingUtil) {
		super(parkingUtil);
	}
	
	@Override
	public boolean validate(CommandDTO commandDto) {
		List<String> commandParameter = commandDto.getCommandArray();
		String driverAge = commandParameter.get(2);
		return commandParameter.size()== 3 && parkingUtil.isInteger(driverAge);	
	}

	@Override
	public void execute(CommandDTO commandDto) {

		String registration = commandDto.getCommandArray().get(0);
		Integer driverAge = Integer.parseInt(commandDto.getCommandArray().get(2));
		Vehicle veh = new Vehicle(registration);
		Driver driver = new Driver(driverAge);
		parkingUtil.park(veh, driver);
	}

}
