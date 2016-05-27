package com.workscape.vehicleidentifier.model;

import javax.xml.bind.annotation.XmlElement;

public class Frame {
	
	private String material;

	@XmlElement 
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
