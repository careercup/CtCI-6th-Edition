package Q7_04_Parking_Lot;

/* Represents a level in a parking garage */
public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0; // number of free spots
	private static final int SPOTS_PER_ROW = 10;
	
	public Level(int flr, int numberSpots) {
		floor = flr;
		spots = new ParkingSpot[numberSpots];
		int largeSpots = numberSpots / 4;
		int bikeSpots = numberSpots / 4;
		int compactSpots = numberSpots - largeSpots - bikeSpots;
		for (int i = 0; i < numberSpots; i++) {
			VehicleSize sz = VehicleSize.Motorcycle;
			if (i < largeSpots) {
				sz = VehicleSize.Large;
			} else if (i < largeSpots + compactSpots) {
				sz = VehicleSize.Compact;
			}
			int row = i / SPOTS_PER_ROW;
			spots[i] = new ParkingSpot(this, row, i, sz);
		}
		availableSpots = numberSpots;
	}
	
	public int availableSpots() {
		return availableSpots;
	}
	
	/* Try to find a place to park this vehicle. Return false if failed. */
	public boolean parkVehicle(Vehicle vehicle) {
		if (availableSpots() < vehicle.getSpotsNeeded()) {
			return false;
		}
		int spotNumber = findAvailableSpots(vehicle);
		if (spotNumber < 0) {
			return false;
		}
		return parkStartingAtSpot(spotNumber, vehicle);
	}
	
	/* Park a vehicle starting at the spot spotNumber, and continuing until vehicle.spotsNeeded. */
	private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
		vehicle.clearSpots();
		boolean success = true;
		for (int i = spotNumber; i < spotNumber + vehicle.spotsNeeded; i++) {
			 success &= spots[i].park(vehicle);
		}
		availableSpots -= vehicle.spotsNeeded;
		return success;
	}
	
	/* find a spot to park this vehicle. Return index of spot, or -1 on failure. */
	private int findAvailableSpots(Vehicle vehicle) {
		int spotsNeeded = vehicle.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;
		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (lastRow != spot.getRow()) {
				spotsFound = 0;
				lastRow = spot.getRow();
			}
			if (spot.canFitVehicle(vehicle)) {
				spotsFound++;
			} else {
				spotsFound = 0;
			}
			if (spotsFound == spotsNeeded) {
				return i - (spotsNeeded - 1);
			}
		}
		return -1;
	}
	
	public void print() {
		int lastRow = -1;
		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (spot.getRow() != lastRow) {
				System.out.print("  ");
				lastRow = spot.getRow();
			}
			spot.print();
		}
	}
	
	/* When a car was removed from the spot, increment availableSpots */
	public void spotFreed() {
		availableSpots++;
	}
}
