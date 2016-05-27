package com.workscape.vehicleidentifier.model;

import javax.xml.bind.annotation.XmlElement;

public class Wheel {
	
	private String position;
	private String material;
	
	@XmlElement 
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	@XmlElement 
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}	
	
}
