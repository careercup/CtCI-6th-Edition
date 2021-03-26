package Q4_07_Build_Order.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Project {
	private List<Project> children = new ArrayList<Project>();

	private List<Project> parents = new ArrayList<Project>();

	private HashMap<String, Project> map = new HashMap<String, Project>();
	private String name;

	private boolean processed = false;
	
	public Project(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}
	
	public void addNeighbor(Project node) {
		if (!map.containsKey(node.getName())) {
			children.add(node);
			map.put(node.getName(), node);
			node.addParent(this);
		}
	}
	
	public List<Project> getChildren() {
		return children;
	}

	public boolean isProcessed() {
		return this.processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public List<Project> getParents() {
		return this.parents;
	}

	public void addParent(Project project) {
		this.parents.add(project);
	}

}
