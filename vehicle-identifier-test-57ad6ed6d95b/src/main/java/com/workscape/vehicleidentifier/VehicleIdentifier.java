package com.workscape.vehicleidentifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import com.workscape.vehicleidentifier.model.Bernoulli;
import com.workscape.vehicleidentifier.model.Human;
import com.workscape.vehicleidentifier.model.InternalCombustion;
import com.workscape.vehicleidentifier.model.Vehicle;
import com.workscape.vehicleidentifier.model.Vehicles;
import com.workscape.vehicleidentifier.util.VehicaleType;
import com.workscape.vehicleidentifier.util.XmlUtil;

/**
 * Hello world!
 * 
 */
public class VehicleIdentifier {

	private String fileName;

	public VehicleIdentifier(String fileName) {

		this.fileName = fileName;
	}
	
	/**
	 * This method perform vehicle type identification operation.
	 * @return Map
	 */

	public Map<String, VehicaleType> getIdentifiedVehicales() {

		Map<String, VehicaleType> map = new HashMap<String, VehicaleType>();
		try {

			Vehicles vehicales = (Vehicles) XmlUtil.parseXml(fileName,
					Vehicles.class, Human.class, InternalCombustion.class,
					Bernoulli.class);
			if(vehicales != null){
				for (Vehicle vehicle : vehicales.getVehicle()) {
	
					VehicleIdentifierRule vind = new VehicleIdentifierRule(
							vehicle);
					
					VehicaleType vtype = vind.getVehicaleType();
					if(vtype != null){
						map.put(vehicle.getId(), vtype);
					}
				}
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return map;
	}

	
	/**
	 * This method gives how many vehicles of each type are in the XML.
	 * @return Map
	 */
	public Map<VehicaleType, Integer> getCommanVehicalCount(List<VehicaleType> vList) {
		
		Map<VehicaleType, Integer> vehicleCountMap = new HashMap<VehicaleType, Integer>();
		if(vList != null){
			for (VehicaleType vtype : vList) {
				
				 if(vehicleCountMap.containsKey(vtype)){
			        	
			        	Integer count = vehicleCountMap.get(vtype);
			        	vehicleCountMap.put(vtype, count++);
			        	
			        }else{
			        	
			        	vehicleCountMap.put(vtype, 1);
			        }
			}
		}
		return vehicleCountMap;
	}

	
	public static void main(String[] args) {

		VehicleIdentifier vidn = new VehicleIdentifier("vehicles.xml");
		
		System.out.println("Report that lists each vehicle id and its type");
		System.out.println("----------------------------------------------");
		
		Map<String, VehicaleType> map = vidn.getIdentifiedVehicales();
		
		for (Map.Entry<String, VehicaleType>entry : map.entrySet()) {
		    String key = entry.getKey();
		    VehicaleType value = entry.getValue();
		    System.out.println(key+" - "+value);
		    
		}
		
		System.out.println("\n\n");
		System.out.println("vehicles of each type are in the XML");
		
		List<VehicaleType> vlist  = new ArrayList<VehicaleType>( map.values());
		Map<VehicaleType, Integer> vcount = vidn.getCommanVehicalCount(vlist);
		
		System.out.println("----------------------------");
		
		for (Map.Entry<VehicaleType, Integer> entry : vcount.entrySet()) {
			VehicaleType key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println(key+" - "+value);
		}
		
	}
}
