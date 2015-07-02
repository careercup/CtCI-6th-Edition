package Q7_11_File_System;

public abstract class Entry {
	protected Directory parent;
	protected long created;
	protected long lastUpdated;
	protected long lastAccessed;
	protected String name;
	
	public Entry(String n, Directory p) {
		name = n;
		parent = p;
		created = System.currentTimeMillis();
	}
	
	public boolean delete() {
		if (parent == null) {
			return false;
		}
		return parent.deleteEntry(this);
	}
	
	public abstract int size();
	
	public String getFullPath() {
		if (parent == null) {
			return name;
		} else {
			return parent.getFullPath() + "/" + name;
		}
	}
	
	public long getCreationTime() {
		return created;
	}
	
	public long getLastUpdatedTime() {
		return lastUpdated;
	}
	
	public long getLastAccessedTime() {
		return lastAccessed;
	}
	
	public void changeName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
}
