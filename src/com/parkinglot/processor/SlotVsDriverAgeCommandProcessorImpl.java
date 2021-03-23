package com.parkinglot.processor;

import java.util.Map;

import com.command.constant.CommandType;
import com.parkinglot.model.CommandDTO;
import com.parkinglot.model.Slot;
import com.parkinglot.utils.ParkingUtil;

public class SlotVsDriverAgeCommandProcessorImpl extends CommandProcessorImpl {

	public SlotVsDriverAgeCommandProcessorImpl(ParkingUtil parkingUtil) {
		super(parkingUtil);
	}
	
	@Override
	public boolean validate(CommandDTO commandDto) {
		String driverAge  = commandDto.getCommandArray().get(0);
		return commandDto.getCommandArray().size()==1 && parkingUtil.isInteger(driverAge);
	}

	@Override
	public void execute(CommandDTO commandDto) {
		
		Integer driverAge = Integer.parseInt(commandDto.getCommandArray().get(0));
		parkingUtil.getSlotNoForDriverAge(driverAge);
		
	}

}
