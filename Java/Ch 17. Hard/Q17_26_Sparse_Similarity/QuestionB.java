package Q17_26_Sparse_Similarity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import CtCILibrary.AssortedMethods;
import CtCILibrary.HashMapList;

public class QuestionB {
	public static HashMap<DocPair, Double> computeSimilarities(HashMap<Integer, Document> documents) {
		HashMapList<Integer, Integer> wordToDocs = groupWords(documents);
		HashMap<DocPair, Double> similarities = computeIntersections(wordToDocs);
		adjustToSimilarities(documents, similarities);
		return similarities;
	}	
	
	/* Create hash table from each word to where it appears. */
	public static HashMapList<Integer, Integer> groupWords(HashMap<Integer, Document> documents) {
		HashMapList<Integer, Integer> wordToDocs = new HashMapList<Integer, Integer>();

		for (Document doc : documents.values()) {
			ArrayList<Integer> words = doc.getWords();
			for (int word : words) {
				wordToDocs.put(word, doc.getId());
			}
		}
		
		return wordToDocs;
	}
	
	/* Compute intersections of documents. Iterate through each list of 
	 * documents and then each pair within that list, incrementing the 
	 * intersection of each page. */
	public static HashMap<DocPair, Double> computeIntersections(HashMapList<Integer, Integer> wordToDocs) {
		HashMap<DocPair, Double> similarities = new HashMap<DocPair, Double>();
		Set<Integer> words = wordToDocs.keySet();
		for (int word : words) {
			ArrayList<Integer> docs = wordToDocs.get(word);
			Collections.sort(docs);
			for (int i = 0; i < docs.size(); i++) {
				for (int j = i + 1; j < docs.size(); j++) {
					increment(similarities, docs.get(i), docs.get(j));
				}
			}
		}
		
		return similarities;
	}
	
	/* Increment the intersection size of each document pair. */
	public static void increment(HashMap<DocPair, Double> similarities, int doc1, int doc2) {
		DocPair pair = new DocPair(doc1, doc2);
		if (!similarities.containsKey(pair)) {
			similarities.put(pair, 1.0);
		} else {
			similarities.put(pair, similarities.get(pair) + 1);		
		}
	}	
	
	/* Adjust the intersection value to become the similarity. */
	public static void adjustToSimilarities(HashMap<Integer, Document> documents, HashMap<DocPair, Double> similarities) {
		for (Entry<DocPair, Double> entry : similarities.entrySet()) {
			DocPair pair = entry.getKey();
			Double intersection = entry.getValue();
			Document doc1 = documents.get(pair.doc1);
			Document doc2 = documents.get(pair.doc2);
			double union = (double) doc1.size() + doc2.size() - intersection;
			entry.setValue(intersection / union);
		}
	}
	
	public static void main(String[] args) {
		int numDocuments = 10;
		int docSize = 5;
		HashMap<Integer, Document> documents = new HashMap<Integer, Document>();
		for (int i = 0; i < numDocuments; i++) {
			int[] words = AssortedMethods.randomArray(docSize, 0, 10);
			ArrayList<Integer> w = Tester.removeDups(words);
			System.out.println(i + ": " + w.toString());
			Document doc = new Document(i, w);
			documents.put(i, doc);
		}
		
		HashMap<DocPair, Double> similarities = computeSimilarities(documents);
		Tester.printSim(similarities);
	}

}
