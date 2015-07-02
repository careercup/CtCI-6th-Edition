package Q7_04_Parking_Lot;

public class Car extends Vehicle {
	public Car() {
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
	}
	
	public void print() {
		System.out.print("C");
	}	
}
