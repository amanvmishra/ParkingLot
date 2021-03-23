package com.parkinglot.model;

public class Slot {

	private Vehicle vehicle;
	private Integer slotNumber;
	private Driver driver;

	public Slot(final Integer slotNumber, Vehicle vehicle, Driver driver) {
		this.slotNumber = slotNumber;
		this.vehicle = vehicle;
		this.driver = driver;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Integer getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(Integer slotNumber) {
		this.slotNumber = slotNumber;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
}
