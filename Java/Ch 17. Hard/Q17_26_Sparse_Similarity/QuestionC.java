package Q17_26_Sparse_Similarity;

import CtCILibrary.AssortedMethods;

import java.util.*;
import java.util.Map.Entry;

public class QuestionC {
	public static class Element implements Comparable<Element> {
		public int word;
		public int document;
		public Element(int w, int d) {
			word = w;
			document = d;
		}
		
		public int compareTo(Element e) {
			if (word == e.word) {
				return document - e.document;
			}
			return word - e.word;
		}
	}

	public static Map<DocPair, Double> computeSimilarities(Map<Integer, Document> documents) {
		List<Element> elements = sortWords(documents);
		Map<DocPair, Double> similarities = computeIntersections(elements);
		adjustToSimilarities(documents, similarities);
		return similarities;
	}	
	
	/* Throw all words into one list, sorting by the word then the document. */
	public static List<Element> sortWords(Map<Integer, Document> docs) {
		List<Element> elements = new ArrayList<>();
		for (Document doc : docs.values()) {
			List<Integer> words = doc.getWords();
			for (int word : words) {
				elements.add(new Element(word, doc.getId()));
			}
		}
		Collections.sort(elements);
		return elements;
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
	public static Map<DocPair, Double> computeIntersections(List<Element> elements) {
		Map<DocPair, Double> similarities = new HashMap<>();
		
		for (int i = 0; i < elements.size(); i++) {
			Element left = elements.get(i);
			for (int j = i + 1; j < elements.size(); j++) {
				Element right = elements.get(j);
				if (left.word != right.word) {
					break;
				}
				increment(similarities, left.document, right.document);	
			}
		}
		
		return similarities;
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
		Map<Integer, Document> documents = new HashMap<>();
		for (int i = 0; i < numDocuments; i++) {
			int[] words = AssortedMethods.randomArray(docSize, 0, 10);
			List<Integer> w = Tester.removeDups(words);
			System.out.println(i + ": " + w);
			Document doc = new Document(i, w);
			documents.put(i, doc);
		}

		Map<DocPair, Double> similarities = computeSimilarities(documents);
		Tester.printSim(similarities);
	}

}
