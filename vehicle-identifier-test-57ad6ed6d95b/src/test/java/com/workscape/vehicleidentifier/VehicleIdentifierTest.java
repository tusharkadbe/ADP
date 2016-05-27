package com.workscape.vehicleidentifier;


import static junit.framework.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.workscape.vehicleidentifier.util.VehicaleType;

/**
 * Unit test for simple App.
 */
public class VehicleIdentifierTest {

	VehicleIdentifier vehicleIdentifier;
	

	
	@Test
	public void testgetIdentifiedVehicales() {
		
		vehicleIdentifier = new VehicleIdentifier("vehicles.xml");
		Map<String, VehicaleType> map = vehicleIdentifier.getIdentifiedVehicales();
		
		assertNotNull(map);
		assertEquals(map.get("vehicle 1"), VehicaleType.BIGWHEEL);
		assertEquals(map.get("vehicle 2"), VehicaleType.BICYCLE);
		assertEquals(map.get("vehicle 3"), VehicaleType.MOTORCYCLE);
		assertEquals(map.get("vehicle 4"), VehicaleType.HANGGLIDER);
		assertEquals(map.get("vehicle 5"), VehicaleType.CAR);
	}
	
	@Test
	public void testgetIdentifiedVehicales_FileNotFound() {
		
		vehicleIdentifier = new VehicleIdentifier("test.xml");
		Map<String, VehicaleType> map = vehicleIdentifier.getIdentifiedVehicales();
		
		assertTrue(map.isEmpty());
		
	}
	
	@Test
	public void testgetCommanVehicalCount() {
		
		vehicleIdentifier = new VehicleIdentifier("vehicles.xml");
		Map<String, VehicaleType> map = vehicleIdentifier.getIdentifiedVehicales();
		Map<VehicaleType, Integer> vcountMap = vehicleIdentifier.getCommanVehicalCount(new ArrayList<VehicaleType>(map.values()));
		
		Integer count =1 ;
		
		assertNotNull(vcountMap);
		assertEquals(vcountMap.get(VehicaleType.BIGWHEEL), count);
		assertEquals(vcountMap.get(VehicaleType.BICYCLE), count);
		assertEquals(vcountMap.get(VehicaleType.MOTORCYCLE), count);
		assertEquals(vcountMap.get(VehicaleType.HANGGLIDER), count);
		assertEquals(vcountMap.get(VehicaleType.CAR),count);
		
	}
	
	
	@Test
	public void testgetCommanVehicalCount_EmtyVehicList() {
		
		
		///Map<VehicaleType, Integer> vcountMap = vehicleIdentifier.getCommanVehicalCount(new ArrayList<VehicaleType>());
		vehicleIdentifier = new VehicleIdentifier("vehicles.xml");
		List<VehicaleType> t = null;
		Map<VehicaleType, Integer> vcountMap = vehicleIdentifier.getCommanVehicalCount(t);
		assertTrue(vcountMap.isEmpty());
		
		
	}
	
}
