package com.workscape.vehicleidentifier.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class Wheels {
	
	private ArrayList<Wheel> wheel;
	
	@XmlElement(name="wheel") 
	public ArrayList<Wheel> getWheel() {
		if(wheel == null)
			wheel = new ArrayList<Wheel>();
		return wheel;
	}

	public void setWheels(ArrayList<Wheel> wheel) {
		this.wheel = wheel;
	}

}
