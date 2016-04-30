package Q17_07_Baby_Names;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QuestionA {

	/* Read through (name, frequency) pairs and initialize a mapping
	 * of names to NameSets (equivalence classes).*/
	public static Map<String, NameSet> constructGroups(Map<String, Integer> names) {
		Map<String, NameSet> groups = new HashMap<>();
		for (Entry<String, Integer> entry : names.entrySet()) {
		    String name = entry.getKey();
		    int frequency = entry.getValue();
		    NameSet group = new NameSet(name, frequency);
		    groups.put(name,  group);
		}
		return groups;
	}

	public static void mergeClasses(Map<String, NameSet> groups, String[][] synonyms) {
		for (String[] entry : synonyms) {
		    String name1 = entry[0];
		    String name2 = entry[1];
		    NameSet set1 = groups.get(name1);
		    NameSet set2 = groups.get(name2);
		    if (set1 != set2) {
		    	/* Always merge the smaller set into the bigger one. */
		    	NameSet smaller = set2.size() < set1.size() ? set2 : set1;
		    	NameSet bigger = set2.size() < set1.size() ? set1 : set2;
		    	
			    /* Merge lists */
			    Set<String> otherNames = smaller.getNames();
			    int frequency = smaller.getFrequency();
			    bigger.copyNamesWithFrequency(otherNames, frequency);
			    
			    /* Update mapping */
			    for (String name : otherNames) {
			    	groups.put(name,  bigger);
			    }
		    }
		}
	}

	public static Map<String, Integer> convertToMap(Map<String, NameSet> groups) {
		Map<String, Integer> list = new HashMap<>();
		for (NameSet group : groups.values()) {
			list.put(group.getRootName(), group.getFrequency());
		}
		return list;
	}

	public static Map<String, Integer> trulyMostPopular(Map<String, Integer> names, String[][] synonyms) {
		Map<String, NameSet> groups = constructGroups(names);
		mergeClasses(groups, synonyms);
		return convertToMap(groups);
	}
	
	public static void main(String[] args) {
		Map<String, Integer> names = new HashMap<>();
		
		names.put("John", 3);
		names.put("Jonathan", 4);
		names.put("Johnny", 5);
		names.put("Chris", 1);
		names.put("Kris", 3);
		names.put("Brian", 2);
		names.put("Bryan", 4);
		names.put("Carleton", 4);
		
		String[][] synonyms = 
			{{"John", "Jonathan"}, 
			 {"Jonathan", "Johnny"}, 
			 {"Chris", "Kris"}, 
			 {"Brian", "Bryan"}};

		Map<String, Integer> finalList = trulyMostPopular(names, synonyms);
		for (Entry<String, Integer> entry : finalList.entrySet()) {
		    String name = entry.getKey();
		    int frequency = entry.getValue();
		    System.out.println(name + ": " + frequency);
		}
	}

}
