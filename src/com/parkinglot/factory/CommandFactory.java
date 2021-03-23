package com.parkinglot.factory;

import com.command.constant.CommandType;
import com.parkinglot.processor.CommandProcessorImpl;
import com.parkinglot.processor.CreateParkingCommandLotProcessorImpl;
import com.parkinglot.processor.LeaveSlotCommandProcessorImpl;
import com.parkinglot.processor.ParkVehicleCommandProcessorImpl;
import com.parkinglot.processor.SlotVsDriverAgeCommandProcessorImpl;
import com.parkinglot.processor.SlotVsRegistrationNumberCommandProcessorImpl;
import com.parkinglot.processor.VehicleRegNoVsAgeCommandProcessorImpl;
import com.parkinglot.utils.ParkingUtil;

public class CommandFactory {

	public static CommandProcessorImpl getProcessor(CommandType commandType, ParkingUtil parkingUtil) {
		
		switch (commandType.toString()) {
			case "Create_parking_lot":
				  return new CreateParkingCommandLotProcessorImpl(parkingUtil);
			case "Slot_numbers_for_driver_of_age":
				 return new SlotVsDriverAgeCommandProcessorImpl(parkingUtil);
			case "Slot_number_for_car_with_number":
				return new SlotVsRegistrationNumberCommandProcessorImpl(parkingUtil);
			case "Park":
				return new ParkVehicleCommandProcessorImpl(parkingUtil);
			case "Leave":
				return new LeaveSlotCommandProcessorImpl(parkingUtil);
			case "Vehicle_registration_number_for_driver_of_age":	
			    return new VehicleRegNoVsAgeCommandProcessorImpl(parkingUtil);
		}
		return null;
	}
	
}
