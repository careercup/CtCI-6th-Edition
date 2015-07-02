package Q7_07_Chat_Server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class User {
	private int id;
	private UserStatus status = null;
	private HashMap<Integer, PrivateChat> privateChats = new HashMap<Integer, PrivateChat>();
	private ArrayList<GroupChat> groupChats = new ArrayList<GroupChat>();
	private HashMap<Integer, AddRequest> receivedAddRequests = new HashMap<Integer, AddRequest>();
	private HashMap<Integer, AddRequest> sentAddRequests = new HashMap<Integer, AddRequest>();
	
	private HashMap<Integer, User> contacts = new HashMap<Integer, User>();
	private String accountName;
	private String fullName;
	
	public User(int id, String accountName, String fullName) {
		this.accountName = accountName;
		this.fullName = fullName;
		this.id = id;
	}
	
	public boolean sendMessageToUser(User toUser, String content) {
		PrivateChat chat = privateChats.get(toUser.getId());
		if (chat == null) {
			chat = new PrivateChat(this, toUser);
			privateChats.put(toUser.getId(), chat);
		}
		Message message = new Message(content, new Date());
		return chat.addMessage(message);
	}
	
	public boolean sendMessageToGroupChat(int groupId, String content) {
		GroupChat chat = groupChats.get(groupId);
		if (chat != null) {
			Message message = new Message(content, new Date());
			return chat.addMessage(message);
		}
		return false;
	}
	
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
	public UserStatus getStatus() {
		return status;
	}
	
	public boolean addContact(User user) {
		if (contacts.containsKey(user.getId())) {
			return false;
		} else {
			contacts.put(user.getId(), user);
			return true;
		}
	}
	
	public void receivedAddRequest(AddRequest req) {
		int senderId = req.getFromUser().getId();
		if (!receivedAddRequests.containsKey(senderId)) {
			receivedAddRequests.put(senderId, req);
		}		
	}
	
	public void sentAddRequest(AddRequest req) {
		int receiverId = req.getFromUser().getId();
		if (!sentAddRequests.containsKey(receiverId)) {
			sentAddRequests.put(receiverId, req);
		}		
	}
	
	public void removeAddRequest(AddRequest req) {
		if (req.getToUser() == this) {
			receivedAddRequests.remove(req);
		} else if (req.getFromUser() == this) {
			sentAddRequests.remove(req);
		}
	}
	
	public void requestAddUser(String accountName) {
		UserManager.getInstance().addUser(this, accountName);
	}
	
	public void addConversation(PrivateChat conversation) {
		User otherUser = conversation.getOtherParticipant(this);
		privateChats.put(otherUser.getId(), conversation);
	}

	public void addConversation(GroupChat conversation) {
		groupChats.add(conversation);
	}	
	
	public int getId() {
		return id;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public String getFullName() {
		return fullName;
	}
}
