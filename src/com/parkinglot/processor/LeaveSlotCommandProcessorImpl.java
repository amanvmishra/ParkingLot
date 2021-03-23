package com.parkinglot.processor;

import com.parkinglot.model.CommandDTO;
import com.parkinglot.utils.ParkingUtil;

public class LeaveSlotCommandProcessorImpl extends CommandProcessorImpl {

	public LeaveSlotCommandProcessorImpl(ParkingUtil parkingUtil) {
		super(parkingUtil);
	}
	
	@Override
	public boolean validate(CommandDTO commandDto) {
		String slotNumberToBeReleased = commandDto.getCommandArray().get(0);
		return commandDto.getCommandArray().size()==1 && parkingUtil.isInteger(slotNumberToBeReleased);
	}

	@Override
	public void execute(CommandDTO commandDto) {
		Integer slotNumberToBeReleased = Integer.parseInt(commandDto.getCommandArray().get(0));
		parkingUtil.leaveSlot(slotNumberToBeReleased);
	}

}
