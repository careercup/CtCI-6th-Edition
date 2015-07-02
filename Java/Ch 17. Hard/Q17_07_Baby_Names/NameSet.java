package Q17_07_Baby_Names;

import java.util.HashSet;
import java.util.Set;

public class NameSet {
	private Set<String> names = new HashSet<String>();
	private int frequency = 0;
	private String rootName;
	
	public NameSet(String name, int freq) {
		names.add(name);
		frequency = freq;
		rootName = name;
	}
	
	public Set<String> getNames() {
		return names;
	}
	
	public String getRootName() {
		return rootName;
	}
	
	public void copyNamesWithFrequency(Set<String> more, int freq) {
		names.addAll(more);
		frequency += freq;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public int size() {
		return names.size();
	}
}
