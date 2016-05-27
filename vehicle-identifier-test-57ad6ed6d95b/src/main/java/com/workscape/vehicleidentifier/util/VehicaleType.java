package com.workscape.vehicleidentifier.util;

public enum VehicaleType {
	
	BIGWHEEL("Big Wheel"), BICYCLE("Bicyle"), MOTORCYCLE("Motorcycle"), HANGGLIDER("Hang Glider"), CAR("Car");
	
	private String vehicalType;
	
	private VehicaleType(String vehicalType) {
		this.vehicalType = vehicalType;
	}

	public String getVehicalType() {
		return vehicalType;
	}

}
