package Q9_02_Social_Network;

import java.util.HashMap;

public class Machine {
	public HashMap<Integer, Person> persons = new HashMap<Integer, Person>();
	public int machineID;
	
	public Person getPersonWithID(int personID) {
		return persons.get(personID);
	}	
}
