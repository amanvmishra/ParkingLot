package com.parkinglot.processor;

import com.parkinglot.model.CommandDTO;
import com.parkinglot.utils.ParkingUtil;

public class CreateParkingCommandLotProcessorImpl extends CommandProcessorImpl {

	public CreateParkingCommandLotProcessorImpl(ParkingUtil parkingUtil) {
		super(parkingUtil);
	}
	
	@Override
	public boolean validate(CommandDTO commandDto) {

		String noOfSlotsToBeCreated = commandDto.getCommandArray().get(0);
		return commandDto.getCommandArray().size()==1 && parkingUtil.isInteger(noOfSlotsToBeCreated);
	}

	@Override
	public void execute(CommandDTO commandDto) {
	   Integer noOfSlotsToBeCreated = Integer.parseInt(commandDto.getCommandArray().get(0));
	   parkingUtil.createParkingLot(noOfSlotsToBeCreated);
	}

}
