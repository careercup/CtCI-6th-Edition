package Q7_07_Chat_Server;

public class PrivateChat extends Conversation {
	public PrivateChat(User user1, User user2) {
		participants.add(user1);
		participants.add(user2);
	}
	
	public User getOtherParticipant(User primary) {
		if (participants.get(0) == primary) {
			return participants.get(1);
		} else if (participants.get(1) == primary) {
			return participants.get(0);
		}
		return null;
	}
}
