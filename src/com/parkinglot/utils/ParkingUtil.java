package com.parkinglot.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.parkinglot.model.Driver;
import com.parkinglot.model.Slot;
import com.parkinglot.model.Vehicle;

public class ParkingUtil {

	TreeSet<Integer> slotRecord = new TreeSet<>();
	Map<Integer, Slot> slotNumberVsVehicle = new HashMap<>();

	public boolean isInteger(String value) {
		
		if (value == null || value == "") {
			return false;
		}
		try {
			Integer d = Integer.parseInt(value);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	
	public void createParkingLot(Integer noOfSlots) {
		for (int i = 0; i < noOfSlots; i++) {
			slotRecord.add(i);
		}
		System.out.println("Created Parking lot of " + noOfSlots + " slots");
	}

	public void park(Vehicle veh, Driver driver) {

		if (null != slotRecord && !slotRecord.isEmpty()) {
			int slotNumber = slotRecord.first();
			Slot slot = new Slot(slotNumber, veh, driver);
			slotNumberVsVehicle.put(slotNumber, slot);
			slotRecord.remove(slotNumber);
			System.out.println("Car with vehicle registration number " + veh.getRegistrationNumber()
					+ " has been parked at slot number " + (slotNumber + 1));
		} else {
			System.out.println("Sorry, Parking lot is full. Please come again after some time!!");
		}

	}

	public void leaveSlot(Integer slotNumber) {
		if (slotNumberVsVehicle.containsKey(slotNumber)) {
			Slot slot = slotNumberVsVehicle.get(slotNumber);
			Vehicle vehicleLeft = slot.getVehicle();
			Driver driver = slot.getDriver();
			slotNumberVsVehicle.remove(slotNumber);
			slotRecord.add(slotNumber);
			System.out.println("Slot No " + (slotNumber+1) + " vacated, the car with registration number ::> "
					+ vehicleLeft.getRegistrationNumber() + " left the space, the driver of the car of the age "
					+ driver.getAge());
		} else {
			System.out.println("Sorry, There is no Car parked at slot number " + (slotNumber + 1));
		}
	}

	public void getSlotsForVehicleRegNo(String vehicleRegNo) {

		boolean found = false;
		if (null != slotNumberVsVehicle && !slotNumberVsVehicle.isEmpty()) {
			for (Map.Entry<Integer, Slot> entry : slotNumberVsVehicle.entrySet()) {
				if (vehicleRegNo.equalsIgnoreCase(entry.getValue().getVehicle().getRegistrationNumber())) {
					System.out.println("Car with Vehicle Registration Number ::> " + vehicleRegNo
							+ " has been parked at slot number ::> " + (entry.getKey() + 1));
					found = true;
				}
			}
		}

		if (!found) {
			System.out.println("Couldn't find Car with Vehicle Registration Number ::> " + vehicleRegNo);
		}
	}

	public void getSlotNoForDriverAge(Integer driverAge) {

		StringBuilder slotNumber = new StringBuilder();
		if (null != slotNumberVsVehicle && !slotNumberVsVehicle.isEmpty()) {
			for (Map.Entry<Integer, Slot> entry : slotNumberVsVehicle.entrySet()) {
				if (driverAge == entry.getValue().getDriver().getAge()) {
					slotNumber.append(entry.getValue().getSlotNumber() + ", ");
				}
			}
		}

		if (slotNumber.length() == 0) {
			System.out.println("There are no car parked with driver of age " + driverAge);
			return;
		}

		System.out.println(slotNumber.substring(0, slotNumber.length() - 2));
	}

	public void getRegNoForDriverAge(Integer driverAge) {

		StringBuilder vehRegNo = new StringBuilder();
		if (null != slotNumberVsVehicle && !slotNumberVsVehicle.isEmpty()) {
			for (Map.Entry<Integer, Slot> entry : slotNumberVsVehicle.entrySet()) {
				if (driverAge == entry.getValue().getDriver().getAge()) {
					vehRegNo.append(entry.getValue().getVehicle().getRegistrationNumber() + ", ");
				}
			}
		}

		if (vehRegNo.length() == 0) {
			System.out.println("There are no car parked with driver of age " + driverAge);
			return;
		}

		System.out.print(vehRegNo.substring(0, vehRegNo.length() - 1));
	}

}
