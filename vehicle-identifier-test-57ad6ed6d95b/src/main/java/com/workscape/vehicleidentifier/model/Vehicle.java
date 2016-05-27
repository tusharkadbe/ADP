package com.workscape.vehicleidentifier.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Vehicle {
	
	private String id;
	
	private Frame frame;
	
	private Wheels wheels;
	
	private PowerTrain powerTrain;

	@XmlElement 
	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	@XmlElement(name="wheels") 
	public Wheels getWheels() {
		return wheels;
	}

	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}

	@XmlElement(name="powertrain")
	public PowerTrain getPowerTrain() {
		return powerTrain;
	}

	public void setPowerTrain(PowerTrain powerTrain) {
		this.powerTrain = powerTrain;
	}

	@XmlElement 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
