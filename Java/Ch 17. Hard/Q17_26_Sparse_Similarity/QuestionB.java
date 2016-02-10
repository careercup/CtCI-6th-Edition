package Q17_26_Sparse_Similarity;

import CtCILibrary.AssortedMethods;
import CtCILibrary.HashMapList;

import java.util.*;
import java.util.Map.Entry;

public class QuestionB {
	public static Map<DocPair, Double> computeSimilarities(Map<Integer, Document> documents) {
		HashMapList<Integer, Integer> wordToDocs = groupWords(documents);
		Map<DocPair, Double> similarities = computeIntersections(wordToDocs);
		adjustToSimilarities(documents, similarities);
		return similarities;
	}	
	
	/* Create hash table from each word to where it appears. */
	public static HashMapList<Integer, Integer> groupWords(Map<Integer, Document> documents) {
		HashMapList<Integer, Integer> wordToDocs = new HashMapList<Integer, Integer>();

		for (Document doc : documents.values()) {
			List<Integer> words = doc.getWords();
			for (int word : words) {
				wordToDocs.put(word, doc.getId());
			}
		}
		
		return wordToDocs;
	}
	
	/* Compute intersections of documents. Iterate through each list of 
	 * documents and then each pair within that list, incrementing the 
	 * intersection of each page. */
	public static Map<DocPair, Double> computeIntersections(HashMapList<Integer, Integer> wordToDocs) {
		Map<DocPair, Double> similarities = new HashMap<DocPair, Double>();
		Set<Integer> words = wordToDocs.keySet();
		for (int word : words) {
			List<Integer> docs = wordToDocs.get(word);
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
	public static void increment(Map<DocPair, Double> similarities, int doc1, int doc2) {
		DocPair pair = new DocPair(doc1, doc2);
		if (!similarities.containsKey(pair)) {
			similarities.put(pair, 1.0);
		} else {
			similarities.put(pair, similarities.get(pair) + 1);		
		}
	}	
	
	/* Adjust the intersection value to become the similarity. */
	public static void adjustToSimilarities(Map<Integer, Document> documents, Map<DocPair, Double> similarities) {
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
		Map<Integer, Document> documents = new HashMap<Integer, Document>();
		for (int i = 0; i < numDocuments; i++) {
			int[] words = AssortedMethods.randomArray(docSize, 0, 10);
			List<Integer> w = Tester.removeDups(words);
			System.out.println(i + ": " + w.toString());
			Document doc = new Document(i, w);
			documents.put(i, doc);
		}

		Map<DocPair, Double> similarities = computeSimilarities(documents);
		Tester.printSim(similarities);
	}

}
