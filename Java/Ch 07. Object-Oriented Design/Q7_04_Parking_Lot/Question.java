package Q7_04_Parking_Lot;

import CtCILibrary.AssortedMethods;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot();
		
		Vehicle v = null;
		while (v == null || lot.parkVehicle(v)) {
			lot.print();
			int r = AssortedMethods.randomIntInRange(0, 10);
			if (r < 2) {
				v = new Bus();
			} else if (r < 4) {
				v = new Motorcycle();
			} else {
				v = new Car();
			}
			System.out.print("\nParking a ");
			v.print();
			System.out.println("");
		}
		System.out.println("Parking Failed. Final state: ");
		lot.print();
	}

}
