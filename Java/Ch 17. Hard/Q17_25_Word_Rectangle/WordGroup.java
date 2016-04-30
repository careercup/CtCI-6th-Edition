package Q17_25_Word_Rectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* A container for a group of words of the same length. */
public class WordGroup {
    private Map<String, Boolean> lookup = new HashMap<>();
    private List<String> group = new ArrayList<>();

    public boolean containsWord(String s) {
    	return lookup.containsKey(s);
    }
    
    public void addWord (String s) {
        group.add(s);
        lookup.put(s, true);
    }
    
    public int length() {
        return group.size();
    }
    
    public String getWord(int i) {
        return group.get(i);
    }

    public List<String> getWords() {
        return group;
    }
    
    public static WordGroup[] createWordGroups(String[] list) {
    	WordGroup[] groupList;
    	int maxWordLength = 0;
		// Find out the length of the longest word
        for (String value : list) {
            if (value.length() > maxWordLength) {
                maxWordLength = value.length();
            }
        }

		/* Group the words in the dictionary into lists of words of 
		 * same length.groupList[i] will contain a list of words, each 
		 * of length (i+1). */
		groupList = new WordGroup[maxWordLength];
        for (String value : list) {
            /* We do wordLength - 1 instead of just wordLength since this is used as
             * an index and no words are of length 0 */
            int wordLength = value.length() - 1;
            if (groupList[wordLength] == null) {
                groupList[wordLength] = new WordGroup();
            }
            groupList[wordLength].addWord(value);
        }
        return groupList;
    }
}
