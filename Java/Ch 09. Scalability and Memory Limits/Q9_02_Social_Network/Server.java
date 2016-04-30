package Q9_02_Social_Network;

import java.util.HashMap;
import java.util.Map;

public class Server {
	Map<Integer, Machine> machines = new HashMap<>();
	Map<Integer, Integer> personToMachineMap = new HashMap<>();
	
	public Machine getMachineWithId(int machineID) {
		return machines.get(machineID);
	}
	
	public int getMachineIDForUser(int personID) {
		Integer machineID = personToMachineMap.get(personID);
		return machineID == null ? -1 : machineID;
	}
	
	public Person getPersonWithID(int personID) {
		Integer machineID = personToMachineMap.get(personID);
		if (machineID == null) {
			return null;
		}
		Machine machine = getMachineWithId(machineID);
		if (machine == null) {
			return null;
		}
		return machine.getPersonWithID(personID);
	}
}
