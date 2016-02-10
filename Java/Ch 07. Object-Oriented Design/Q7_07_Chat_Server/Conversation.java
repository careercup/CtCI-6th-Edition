package Q7_07_Chat_Server;

import java.util.ArrayList;
import java.util.List;

public abstract class Conversation {
	protected List<User> participants = new ArrayList<>();
	protected int id;
	protected List<Message> messages = new ArrayList<>();

	public List<Message> getMessages() {
		return messages;
	}
	
	public boolean addMessage(Message m) {
		messages.add(m);
		return true;
	}
	
	public int getId() {
		return id;
	}
}
