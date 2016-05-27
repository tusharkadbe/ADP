package com.workscape.vehicleidentifier;

import com.workscape.vehicleidentifier.model.Bernoulli;
import com.workscape.vehicleidentifier.model.Frame;
import com.workscape.vehicleidentifier.model.Human;
import com.workscape.vehicleidentifier.model.InternalCombustion;
import com.workscape.vehicleidentifier.model.Vehicle;
import com.workscape.vehicleidentifier.util.VehicaleType;

public class VehicleIdentifierRule {

	private Vehicle vehicle;

	public VehicleIdentifierRule(Vehicle v) {
		this.vehicle = v;
	}

	public VehicaleType getVehicaleType() {
		
		int count = vehicle.getWheels() == null ? 0 : vehicle.getWheels().getWheel().size();
		Object object = vehicle.getPowerTrain() == null ? null : vehicle.getPowerTrain().getAny().get(0);
		String material = vehicle.getFrame() == null ? null : vehicle.getFrame().getMaterial();
		
		VehicaleType v = null;
		
		if(isBigwheel(count, object, material)){
			
			v = VehicaleType.BIGWHEEL;
			
		}else if(isBiycle(count, object, material)){
			
			v = VehicaleType.BICYCLE;
			
		}else if(isMotorcycle(count, object, material)){
			
			v = VehicaleType.MOTORCYCLE;
			
		}else if(isHangGlider(count, object, material)){
			
			v = VehicaleType.HANGGLIDER;
			
		}else if(isCar(count, object, material)){
			
			v = VehicaleType.CAR;
			
		}
			
		return v;
	}

	private boolean isBigwheel(int count , Object object, String material) {
		
		return "plastic".equalsIgnoreCase(material)
				&& 3 == count
				&& object instanceof Human;
	}

	private boolean isBiycle(int count , Object object, String material) {
		
		return "metal".equalsIgnoreCase(material)
				&& 2 == count
				&& object instanceof Human;
	}
	
	private boolean isMotorcycle(int count , Object object,  String material) {
		
		return "metal".equalsIgnoreCase(material)
				&& 2 == count
				&& object instanceof InternalCombustion;
	}
	
	private boolean isHangGlider(int count , Object object, String material) {
		
		return "plastic".equalsIgnoreCase(material)
				&& 0 == count
				&& object instanceof Bernoulli;
	}
	
	private boolean isCar(int count , Object object,  String material) {
		
		return "metal".equalsIgnoreCase(material)
				&& 4 == count
				&& object instanceof InternalCombustion;
	}
	
}
