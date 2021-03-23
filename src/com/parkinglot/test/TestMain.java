package com.parkinglot.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.parkinglot.factory.CommandFactory;
import com.parkinglot.model.CommandDTO;
import com.parkinglot.processor.CommandProcessor;
import com.parkinglot.utils.ParkingUtil;

public class TestMain {

	public static void main(String[] args) {

		/*String str = "Create_parking_lot 6\r\n" + "Park KA-01-HH-1234 driver_age 21\r\n"
				+ "Park PB-01-HH-1234 driver_age 21\r\n" + "Slot_numbers_for_driver_of_age 21\r\n"
				+ "Park PB-01-TG-2341 driver_age 40\r\n" + "Slot_number_for_car_with_number PB-01-HH-1234\r\n"
				+ "Leave 2\r\n" + "Park HR-29-TG-3098 driver_age 39\r\n"
				+ "Vehicle_registration_number_for_driver_of_age 18";

		List<String> commands = Arrays.asList(str.split("\r\n"));
		CommandProcessorImpl processorImpl = null;
		ParkingUtil parkingUtil = new ParkingUtil();
		for (String input : commands) {
			CommandDTO command = new CommandDTO(input);
			CommandProcessor commandProcessor = CommandFactory.getProcessor(command.getCommandType(), parkingUtil);
			if (commandProcessor.validate(command)) {
				commandProcessor.execute(command);
			}
		}*/
		
		final File file = new File(args[0]);
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			ParkingUtil parkingUtil = new ParkingUtil();
			String input = reader.readLine();
			while (null != input) {
				CommandDTO command = new CommandDTO(input);
				CommandProcessor commandProcessor = CommandFactory.getProcessor(command.getCommandType(), parkingUtil);
				if (commandProcessor.validate(command)) {
					commandProcessor.execute(command);
				}
				input = reader.readLine();
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("Error Occured while reading commands ::>");
		} catch (IOException io) {
			System.out.println("Error Occured while reading commands ::>");
		}

	}

}
