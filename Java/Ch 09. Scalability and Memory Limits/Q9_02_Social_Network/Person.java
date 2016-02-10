package Q9_02_Social_Network;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private List<Integer> friends = new ArrayList<Integer>();
	private int personID;
	private String info;
	
	public String getInfo() { return info; }
	public void setInfo(String info) {
		this.info = info;
	}

	public List<Integer> getFriends() {
		return friends;
	}
	
	public int getID() { return personID; }
	public void addFriend(int id) { friends.add(id); }
	
	public Person(int id) {
		this.personID = id;
	}
}
