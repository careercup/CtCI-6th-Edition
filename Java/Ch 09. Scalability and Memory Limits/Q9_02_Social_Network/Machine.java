package Q9_02_Social_Network;

import java.util.HashMap;
import java.util.Map;

public class Machine {
	public Map<Integer, Person> persons = new HashMap<>();
	public int machineID;
	
	public Person getPersonWithID(int personID) {
		return persons.get(personID);
	}	
}
