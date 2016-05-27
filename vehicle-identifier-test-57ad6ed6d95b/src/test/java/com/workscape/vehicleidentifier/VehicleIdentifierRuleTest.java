package com.workscape.vehicleidentifier;

import java.util.ArrayList;

import org.junit.Test;

import static junit.framework.Assert.*;

import com.workscape.vehicleidentifier.model.Frame;
import com.workscape.vehicleidentifier.model.Human;
import com.workscape.vehicleidentifier.model.PowerTrain;
import com.workscape.vehicleidentifier.model.Vehicle;
import com.workscape.vehicleidentifier.model.Wheel;
import com.workscape.vehicleidentifier.model.Wheels;
import com.workscape.vehicleidentifier.util.VehicaleType;

public class VehicleIdentifierRuleTest {
	
	@Test
	public void testgetVehicaleType(){
		
		Vehicle vehicle = mockedVehicle();
		VehicleIdentifierRule veRule = new VehicleIdentifierRule(vehicle);
		VehicaleType vehicaleType = veRule.getVehicaleType();
		
		assertNotNull(vehicaleType);
		assertEquals(VehicaleType.BIGWHEEL, vehicaleType);
	}
	
	
	@Test
	public void testgetVehicaleType_EmptyVechical(){
		
		Vehicle vehicle = new Vehicle();
		VehicleIdentifierRule veRule = new VehicleIdentifierRule(vehicle);
		VehicaleType vehicaleType = veRule.getVehicaleType();
		
		assertNull(vehicaleType);
		
	}
	
	private Vehicle mockedVehicle(){
		
		Vehicle vec = new Vehicle();
		vec.setId("Vehical 1");
		
		Frame frame = new Frame();
		frame.setMaterial("plastic");
		vec.setFrame(frame);
		
		Wheel wheel = new Wheel(); 
		wheel.setMaterial("plastic");
		wheel.setPosition("front");
		
		Wheel wheel1 = new Wheel(); 
		wheel.setMaterial("plastic");
		wheel.setPosition("rear");
		
		Wheel wheel2 = new Wheel(); 
		wheel.setMaterial("plastic");
		wheel.setPosition("rear");
		
		Wheels wheels = new Wheels();
		wheels.getWheel().add(wheel);
		wheels.getWheel().add(wheel1);
		wheels.getWheel().add(wheel2);
		
		vec.setWheels(wheels);
		
		ArrayList<Object> objList = new ArrayList<Object>(); 
		objList.add(new Human());
		
		PowerTrain powerTrain = new PowerTrain();
		powerTrain.setAny(objList);
		
		vec.setPowerTrain(powerTrain);
		
		
		return vec;
	}

}
