package com.parkinglot.processor;

import com.parkinglot.model.CommandDTO;
import com.parkinglot.utils.ParkingUtil;

public class SlotVsRegistrationNumberCommandProcessorImpl extends CommandProcessorImpl {

	public SlotVsRegistrationNumberCommandProcessorImpl(ParkingUtil parkingUtil) {
		super(parkingUtil);
	}
	
	@Override
	public boolean validate(CommandDTO commandDto) {
		return commandDto.getCommandArray().size() == 1;
	}

	@Override
	public void execute(CommandDTO commandDto) {

		String vehicleRegNo = commandDto.getCommandArray().get(0).trim();
		parkingUtil.getSlotsForVehicleRegNo(vehicleRegNo);
	}

}
